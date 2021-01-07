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
/* loaded from: classes8.dex */
public final class ao implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackFacePageActivity f5721a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(FeedbackFacePageActivity feedbackFacePageActivity) {
        this.f5721a = feedbackFacePageActivity;
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
            view2 = this.f5721a.n;
            view2.setVisibility(0);
            linearLayout = this.f5721a.g;
            linearLayout.setVisibility(8);
            webView = this.f5721a.o;
            webView.setVisibility(0);
            if (!com.baidu.ufosdk.b.d.c(this.f5721a.getApplicationContext())) {
                webView4 = this.f5721a.o;
                webView4.setVisibility(8);
                view3 = this.f5721a.n;
                view3.setVisibility(8);
                Context applicationContext = this.f5721a.getApplicationContext();
                textView = this.f5721a.q;
                com.baidu.ufosdk.f.i.a(applicationContext, textView);
                linearLayout3 = this.f5721a.g;
                linearLayout3.setVisibility(0);
                Toast.makeText(this.f5721a, com.baidu.ufosdk.f.s.a("64"), 1).show();
            } else if (UfoSDK.clientid.length() == 0) {
                Toast.makeText(this.f5721a, com.baidu.ufosdk.f.s.a("62"), 1).show();
                new Thread(new ap(this)).start();
            } else {
                webView2 = this.f5721a.o;
                webView2.loadDataWithBaseURL(null, null, "text/html", "utf-8", null);
                linearLayout2 = this.f5721a.g;
                linearLayout2.setVisibility(8);
                webView3 = this.f5721a.o;
                webView3.setVisibility(0);
                handler = this.f5721a.v;
                handler.obtainMessage(1, null).sendToTarget();
                new Thread(new aq(this)).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
