package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public final class bx implements eq {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f59897a;

    public bx(FeedbackInputActivity feedbackInputActivity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {feedbackInputActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f59897a = feedbackInputActivity;
    }

    @Override // com.baidu.ufosdk.ui.eq
    public final void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (str.equals("我的反馈")) {
                this.f59897a.t = true;
                Intent intent = new Intent(this.f59897a, FeedbackListActivity.class);
                intent.putExtra("feedback_channel", com.baidu.ufosdk.b.f59688j);
                this.f59897a.startActivity(intent);
                this.f59897a.finish();
            } else if (str.equals("人工反馈")) {
                new Thread(new by(this)).start();
            } else if (str.toLowerCase().startsWith("href")) {
                String substring = str.substring(str.indexOf(str.replace(" ", "").toLowerCase().startsWith("href='") ? "'" : "\"") + 1, str.length() - 1);
                if (substring.contains("(=^o^=)Y")) {
                    substring = substring.replace("(=^o^=)Y", "\\\"");
                }
                com.baidu.ufosdk.f.c.a("处理之前的url是：" + str);
                com.baidu.ufosdk.f.c.a("处理之后的url是：" + substring);
                if (substring.startsWith("https://") || substring.startsWith("http://")) {
                    try {
                        com.baidu.ufosdk.f.c.a("打开浏览器...");
                        com.baidu.ufosdk.f.c.a(">>跳转链接：" + substring);
                        this.f59897a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(substring)));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else if (substring.startsWith("baidumap://")) {
                    try {
                        com.baidu.ufosdk.f.c.a("打开地图...");
                        com.baidu.ufosdk.f.c.a("跳转链接：" + substring);
                        Intent intent2 = new Intent();
                        intent2.setAction("android.intent.action.VIEW");
                        intent2.setData(Uri.parse(substring));
                        this.f59897a.startActivity(intent2);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                        Toast.makeText(this.f59897a.getApplicationContext(), "打开失败，未安装百度地图！", 0).show();
                    }
                }
            }
        }
    }
}
