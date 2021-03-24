package com.baidu.ufosdk.ui;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.util.devices.RomUtils;
/* loaded from: classes5.dex */
public final class az implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackHotActivity f23073a;

    public az(FeedbackHotActivity feedbackHotActivity) {
        this.f23073a = feedbackHotActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        View view2;
        LinearLayout linearLayout;
        View view3;
        TextView textView;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        WebView webView;
        if (com.baidu.ufosdk.f.h.a()) {
            return;
        }
        view2 = this.f23073a.l;
        view2.setVisibility(0);
        linearLayout = this.f23073a.f23011h;
        linearLayout.setVisibility(8);
        if (!com.baidu.ufosdk.b.d.b(this.f23073a.getApplicationContext()).contains(RomUtils.UNKNOWN) && !com.baidu.ufosdk.b.d.b(this.f23073a.getApplicationContext()).contains("NONE")) {
            this.f23073a.a();
            linearLayout3 = this.f23073a.f23011h;
            linearLayout3.setVisibility(8);
            webView = this.f23073a.j;
            webView.setVisibility(0);
            return;
        }
        view3 = this.f23073a.l;
        view3.setVisibility(8);
        Context applicationContext = this.f23073a.getApplicationContext();
        textView = this.f23073a.m;
        com.baidu.ufosdk.f.i.a(applicationContext, textView);
        linearLayout2 = this.f23073a.f23011h;
        linearLayout2.setVisibility(0);
    }
}
