package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes21.dex */
final class ax extends Handler {
    final /* synthetic */ FeedbackHotActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(FeedbackHotActivity feedbackHotActivity) {
        this.a = feedbackHotActivity;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        TextView textView;
        WebView webView;
        WebView webView2;
        View view;
        TextView textView2;
        LinearLayout linearLayout;
        WebView webView3;
        super.handleMessage(message);
        if (message.what == 3) {
            webView = this.a.j;
            if (webView.getProgress() < 100) {
                webView2 = this.a.j;
                webView2.stopLoading();
                view = this.a.l;
                view.setVisibility(8);
                Context applicationContext = this.a.getApplicationContext();
                textView2 = this.a.m;
                com.baidu.ufosdk.f.i.a(applicationContext, textView2);
                linearLayout = this.a.h;
                linearLayout.setVisibility(0);
                webView3 = this.a.j;
                webView3.setVisibility(8);
            }
        }
        if (message.what == 0) {
            textView = this.a.n;
            textView.setText(com.baidu.ufosdk.f.s.a("8"));
        }
    }
}
