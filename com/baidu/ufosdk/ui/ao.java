package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.ufosdk.UfoSDK;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class ao implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackFacePageActivity f5438a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(FeedbackFacePageActivity feedbackFacePageActivity) {
        this.f5438a = feedbackFacePageActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        View view2;
        LinearLayout linearLayout;
        WebView webView;
        WebView webView2;
        LinearLayout linearLayout2;
        WebView webView3;
        Handler handler;
        WebView webView4;
        View view3;
        TextView textView;
        LinearLayout linearLayout3;
        if (com.baidu.ufosdk.f.h.a()) {
            return;
        }
        try {
            view2 = this.f5438a.n;
            view2.setVisibility(0);
            linearLayout = this.f5438a.g;
            linearLayout.setVisibility(8);
            webView = this.f5438a.o;
            webView.setVisibility(0);
            if (!com.baidu.ufosdk.b.d.c(this.f5438a.getApplicationContext())) {
                webView4 = this.f5438a.o;
                webView4.setVisibility(8);
                view3 = this.f5438a.n;
                view3.setVisibility(8);
                Context applicationContext = this.f5438a.getApplicationContext();
                textView = this.f5438a.q;
                com.baidu.ufosdk.f.i.a(applicationContext, textView);
                linearLayout3 = this.f5438a.g;
                linearLayout3.setVisibility(0);
                Toast.makeText(this.f5438a, com.baidu.ufosdk.f.s.a("64"), 1).show();
            } else if (UfoSDK.clientid.length() == 0) {
                Toast.makeText(this.f5438a, com.baidu.ufosdk.f.s.a("62"), 1).show();
                new Thread(new ap(this)).start();
            } else {
                webView2 = this.f5438a.o;
                webView2.loadDataWithBaseURL(null, null, "text/html", "utf-8", null);
                linearLayout2 = this.f5438a.g;
                linearLayout2.setVisibility(8);
                webView3 = this.f5438a.o;
                webView3.setVisibility(0);
                handler = this.f5438a.v;
                handler.obtainMessage(1, null).sendToTarget();
                new Thread(new aq(this)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
