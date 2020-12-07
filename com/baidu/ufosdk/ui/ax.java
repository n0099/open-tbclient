package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes22.dex */
final class ax extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackHotActivity f3767a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ax(FeedbackHotActivity feedbackHotActivity) {
        this.f3767a = feedbackHotActivity;
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
            webView = this.f3767a.j;
            if (webView.getProgress() < 100) {
                webView2 = this.f3767a.j;
                webView2.stopLoading();
                view = this.f3767a.l;
                view.setVisibility(8);
                Context applicationContext = this.f3767a.getApplicationContext();
                textView2 = this.f3767a.m;
                com.baidu.ufosdk.f.i.a(applicationContext, textView2);
                linearLayout = this.f3767a.h;
                linearLayout.setVisibility(0);
                webView3 = this.f3767a.j;
                webView3.setVisibility(8);
            }
        }
        if (message.what == 0) {
            textView = this.f3767a.n;
            textView.setText(com.baidu.ufosdk.f.s.a("8"));
        }
    }
}
