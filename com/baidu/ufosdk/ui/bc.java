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
import com.baidu.swan.apps.so.SoUtils;
import com.baidu.ufosdk.UfoSDK;
import java.util.Timer;
/* loaded from: classes5.dex */
public final class bc extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackHotActivity f22841a;

    public bc(FeedbackHotActivity feedbackHotActivity) {
        this.f22841a = feedbackHotActivity;
    }

    public /* synthetic */ bc(FeedbackHotActivity feedbackHotActivity, byte b2) {
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
        view = this.f22841a.l;
        view.setVisibility(8);
        webView.requestFocus();
        timer = this.f22841a.q;
        if (timer != null) {
            timer2 = this.f22841a.q;
            timer2.cancel();
            timer3 = this.f22841a.q;
            timer3.purge();
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        View view;
        Timer timer;
        super.onPageStarted(webView, str, bitmap);
        webView.clearView();
        view = this.f22841a.l;
        view.setVisibility(0);
        this.f22841a.q = new Timer();
        bd bdVar = new bd(this);
        timer = this.f22841a.q;
        timer.schedule(bdVar, 20000L);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i2, String str, String str2) {
        TextView textView;
        LinearLayout linearLayout;
        WebView webView2;
        super.onReceivedError(webView, i2, str, str2);
        Context applicationContext = this.f22841a.getApplicationContext();
        textView = this.f22841a.m;
        com.baidu.ufosdk.f.i.a(applicationContext, textView);
        linearLayout = this.f22841a.f22770h;
        linearLayout.setVisibility(0);
        webView2 = this.f22841a.j;
        webView2.setVisibility(8);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        boolean z;
        com.baidu.ufosdk.f.c.a("webClick ==> click:url-->" + str);
        com.baidu.ufosdk.f.c.a("PluginInvoker.appid=" + UfoSDK.appid);
        if (str.startsWith("feedback://")) {
            FeedbackHotActivity.a(this.f22841a, str);
            return true;
        }
        if (str.startsWith("solve://")) {
            z = this.f22841a.s;
            if (z) {
                return true;
            }
            Toast.makeText(this.f22841a, com.baidu.ufosdk.f.s.a(SoUtils.SO_EVENT_ID_V8_SO), 0).show();
        } else if (str.startsWith("backtoufo://")) {
            this.f22841a.finish();
            return true;
        } else if (!str.startsWith("unsolved://")) {
            if (str.startsWith("https://") || str.startsWith("http://")) {
                try {
                    com.baidu.ufosdk.f.c.a(">>跳转链接：" + str);
                    this.f22841a.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)));
                    return true;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return true;
                }
            } else if (str.startsWith("baidumap://")) {
                try {
                    com.baidu.ufosdk.f.c.a("跳转链接：" + str);
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(Uri.parse(str));
                    this.f22841a.startActivity(intent);
                    return true;
                } catch (Exception e3) {
                    e3.printStackTrace();
                    Toast.makeText(this.f22841a.getApplicationContext(), "打开失败，未安装百度地图！", 0).show();
                    return true;
                }
            } else {
                return true;
            }
        }
        this.f22841a.s = true;
        return true;
    }
}
