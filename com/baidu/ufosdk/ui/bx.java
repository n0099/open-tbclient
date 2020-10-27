package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import com.baidu.sapi2.utils.SapiUtils;
/* loaded from: classes22.dex */
final class bx implements eq {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f3789a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bx(FeedbackInputActivity feedbackInputActivity) {
        this.f3789a = feedbackInputActivity;
    }

    @Override // com.baidu.ufosdk.ui.eq
    public final void a(String str) {
        if (str.equals("我的反馈")) {
            this.f3789a.t = true;
            Intent intent = new Intent(this.f3789a, FeedbackListActivity.class);
            intent.putExtra("feedback_channel", com.baidu.ufosdk.b.j);
            this.f3789a.startActivity(intent);
            this.f3789a.finish();
        } else if (str.equals("人工反馈")) {
            new Thread(new by(this)).start();
        } else if (str.toLowerCase().startsWith("href")) {
            String substring = str.substring((str.replace(" ", "").toLowerCase().startsWith("href='") ? str.indexOf("'") : str.indexOf("\"")) + 1, str.length() - 1);
            if (substring.contains("(=^o^=)Y")) {
                substring = substring.replace("(=^o^=)Y", "\\\"");
            }
            com.baidu.ufosdk.f.c.a("处理之前的url是：" + str);
            com.baidu.ufosdk.f.c.a("处理之后的url是：" + substring);
            if (substring.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX) || substring.startsWith("http://")) {
                try {
                    com.baidu.ufosdk.f.c.a("打开浏览器...");
                    com.baidu.ufosdk.f.c.a(">>跳转链接：" + substring);
                    this.f3789a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(substring)));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (substring.startsWith("baidumap://")) {
                try {
                    com.baidu.ufosdk.f.c.a("打开地图...");
                    com.baidu.ufosdk.f.c.a("跳转链接：" + substring);
                    Intent intent2 = new Intent();
                    intent2.setAction("android.intent.action.VIEW");
                    intent2.setData(Uri.parse(substring));
                    this.f3789a.startActivity(intent2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    Toast.makeText(this.f3789a.getApplicationContext(), "打开失败，未安装百度地图！", 0).show();
                }
            }
        }
    }
}
