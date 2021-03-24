package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
/* loaded from: classes5.dex */
public final class bx implements eq {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f23103a;

    public bx(FeedbackInputActivity feedbackInputActivity) {
        this.f23103a = feedbackInputActivity;
    }

    @Override // com.baidu.ufosdk.ui.eq
    public final void a(String str) {
        if (str.equals("我的反馈")) {
            this.f23103a.t = true;
            Intent intent = new Intent(this.f23103a, FeedbackListActivity.class);
            intent.putExtra("feedback_channel", com.baidu.ufosdk.b.j);
            this.f23103a.startActivity(intent);
            this.f23103a.finish();
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
                    this.f23103a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(substring)));
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
                    this.f23103a.startActivity(intent2);
                } catch (Exception e3) {
                    e3.printStackTrace();
                    Toast.makeText(this.f23103a.getApplicationContext(), "打开失败，未安装百度地图！", 0).show();
                }
            }
        }
    }
}
