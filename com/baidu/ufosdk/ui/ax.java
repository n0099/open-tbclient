package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
/* loaded from: classes5.dex */
public final class ax extends Handler {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackHotActivity f22765a;

    public ax(FeedbackHotActivity feedbackHotActivity) {
        this.f22765a = feedbackHotActivity;
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
            webView = this.f22765a.j;
            if (webView.getProgress() < 100) {
                webView2 = this.f22765a.j;
                webView2.stopLoading();
                view = this.f22765a.l;
                view.setVisibility(8);
                Context applicationContext = this.f22765a.getApplicationContext();
                textView2 = this.f22765a.m;
                com.baidu.ufosdk.f.i.a(applicationContext, textView2);
                linearLayout = this.f22765a.f22705h;
                linearLayout.setVisibility(0);
                webView3 = this.f22765a.j;
                webView3.setVisibility(8);
            }
        }
        if (message.what == 0) {
            textView = this.f22765a.n;
            textView.setText(com.baidu.ufosdk.f.s.a("8"));
        }
    }
}
