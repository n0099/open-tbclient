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
    public final /* synthetic */ FeedbackHotActivity f22767a;

    public az(FeedbackHotActivity feedbackHotActivity) {
        this.f22767a = feedbackHotActivity;
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
        view2 = this.f22767a.l;
        view2.setVisibility(0);
        linearLayout = this.f22767a.f22705h;
        linearLayout.setVisibility(8);
        if (!com.baidu.ufosdk.b.d.b(this.f22767a.getApplicationContext()).contains(RomUtils.UNKNOWN) && !com.baidu.ufosdk.b.d.b(this.f22767a.getApplicationContext()).contains("NONE")) {
            this.f22767a.a();
            linearLayout3 = this.f22767a.f22705h;
            linearLayout3.setVisibility(8);
            webView = this.f22767a.j;
            webView.setVisibility(0);
            return;
        }
        view3 = this.f22767a.l;
        view3.setVisibility(8);
        Context applicationContext = this.f22767a.getApplicationContext();
        textView = this.f22767a.m;
        com.baidu.ufosdk.f.i.a(applicationContext, textView);
        linearLayout2 = this.f22767a.f22705h;
        linearLayout2.setVisibility(0);
    }
}
