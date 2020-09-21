package com.baidu.ufosdk.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.Timer;
/* loaded from: classes21.dex */
final class av extends WebViewClient {
    final /* synthetic */ FeedbackFacePageActivity a;

    private av(FeedbackFacePageActivity feedbackFacePageActivity) {
        this.a = feedbackFacePageActivity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ av(FeedbackFacePageActivity feedbackFacePageActivity, byte b) {
        this(feedbackFacePageActivity);
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        WebView webView2;
        StringBuilder sb = new StringBuilder("UfoWebViewClient --> onLoadResource : ");
        webView2 = this.a.o;
        com.baidu.ufosdk.f.c.c(sb.append(webView2.getProgress()).toString());
        super.onLoadResource(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        View view;
        Timer timer;
        Timer timer2;
        Timer timer3;
        super.onPageFinished(webView, str);
        view = this.a.n;
        view.setVisibility(8);
        timer = this.a.p;
        if (timer != null) {
            timer2 = this.a.p;
            timer2.cancel();
            timer3 = this.a.p;
            timer3.purge();
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        View view;
        Timer timer;
        com.baidu.ufosdk.f.c.c("UfoWebViewClient --> onPageStarted");
        super.onPageStarted(webView, str, bitmap);
        view = this.a.n;
        view.setVisibility(0);
        this.a.p = new Timer();
        aw awVar = new aw(this);
        timer = this.a.p;
        timer.schedule(awVar, 20000L);
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        TextView textView;
        LinearLayout linearLayout;
        WebView webView2;
        View view;
        com.baidu.ufosdk.f.c.c("onReceivedError --> errorCode:" + i + ",description:" + str + ",failingUrl:" + str2);
        super.onReceivedError(webView, i, str, str2);
        Context applicationContext = this.a.getApplicationContext();
        textView = this.a.q;
        com.baidu.ufosdk.f.i.a(applicationContext, textView);
        linearLayout = this.a.g;
        linearLayout.setVisibility(0);
        webView2 = this.a.o;
        webView2.setVisibility(8);
        view = this.a.n;
        view.setVisibility(8);
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        com.baidu.ufosdk.f.c.c("UfoWebViewClient --> shouldOverrideUrlLoading:" + str);
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
