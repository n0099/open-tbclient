package com.baidu.ufosdk.ui;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.swan.games.utils.so.SoUtils;
import com.baidu.ufosdk.UfoSDK;
import java.util.Timer;
/* loaded from: classes21.dex */
final class bc extends WebViewClient {
    final /* synthetic */ FeedbackHotActivity a;

    private bc(FeedbackHotActivity feedbackHotActivity) {
        this.a = feedbackHotActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ bc(FeedbackHotActivity feedbackHotActivity, byte b) {
        this(feedbackHotActivity);
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        View view;
        Timer timer;
        Timer timer2;
        Timer timer3;
        super.onPageFinished(webView, str);
        view = this.a.l;
        view.setVisibility(8);
        webView.requestFocus();
        timer = this.a.q;
        if (timer != null) {
            timer2 = this.a.q;
            timer2.cancel();
            timer3 = this.a.q;
            timer3.purge();
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        View view;
        Timer timer;
        super.onPageStarted(webView, str, bitmap);
        webView.clearView();
        view = this.a.l;
        view.setVisibility(0);
        this.a.q = new Timer();
        bd bdVar = new bd(this);
        timer = this.a.q;
        timer.schedule(bdVar, 20000L);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        TextView textView;
        LinearLayout linearLayout;
        WebView webView2;
        super.onReceivedError(webView, i, str, str2);
        Context applicationContext = this.a.getApplicationContext();
        textView = this.a.m;
        com.baidu.ufosdk.f.i.a(applicationContext, textView);
        linearLayout = this.a.h;
        linearLayout.setVisibility(0);
        webView2 = this.a.j;
        webView2.setVisibility(8);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        boolean z;
        com.baidu.ufosdk.f.c.a("webClick ==> click:url-->" + str);
        com.baidu.ufosdk.f.c.a("PluginInvoker.appid=" + UfoSDK.appid);
        if (str.startsWith("feedback://")) {
            FeedbackHotActivity.a(this.a, str);
            return true;
        } else if (str.startsWith("solve://")) {
            z = this.a.s;
            if (z) {
                return true;
            }
            Toast.makeText(this.a, com.baidu.ufosdk.f.s.a(SoUtils.SO_EVENT_ID_V8_SO), 0).show();
            this.a.s = true;
            return true;
        } else if (str.startsWith("backtoufo://")) {
            this.a.finish();
            return true;
        } else if (str.startsWith("unsolved://")) {
            this.a.s = true;
            return true;
        } else if (str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX) || str.startsWith("http://")) {
            try {
                com.baidu.ufosdk.f.c.a(">>跳转链接：" + str);
                this.a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return true;
            }
        } else if (str.startsWith("baidumap://")) {
            try {
                com.baidu.ufosdk.f.c.a("跳转链接：" + str);
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                this.a.startActivity(intent);
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                Toast.makeText(this.a.getApplicationContext(), "打开失败，未安装百度地图！", 0).show();
                return true;
            }
        } else {
            return true;
        }
    }
}
