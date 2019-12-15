package com.example.duihuakuang;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = (Button) this.findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("这是一个普通的对话框")//显示的消息内容
                        .setTitle("对话框");//对话框标题
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "用户按下了确认按钮", Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "用户按下了取消按钮", Toast.LENGTH_LONG).show();
                    }
                });
                builder.setNeutralButton("忽略", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "用户按下了忽略按钮", Toast.LENGTH_LONG).show();
                    }
                });
                builder.show();
            }
        });
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater inflater = getLayoutInflater();
                final View v=inflater.inflate(R.layout.login_dialog,null);


                builder.setView(v)
                        .setTitle("Login").setPositiveButton("登录", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // login

                        EditText userId = (EditText) v.findViewById(R.id.editTextUserId);
                        EditText pwd = (EditText) v.findViewById(R.id.editTextPwd);


                        String u=userId.getText().toString();
                        String p=pwd.getText().toString();
                        if(u.equals("abc")&&p.equals("123")){
                            Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(MainActivity.this, "登录失败", Toast.LENGTH_LONG).show();
                        }
                    }
                })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //cancel
                                Toast.makeText(MainActivity.this, "用户取消登录", Toast.LENGTH_LONG).show();
                            }
                        });
                builder.show();
            }
        });
    }


}
