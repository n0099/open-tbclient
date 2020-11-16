package com.baidu.ufosdk.ui;

import android.content.Context;
import android.view.View;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.util.devices.RomUtils;
/* loaded from: classes21.dex */
final class az implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackHotActivity f3766a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(FeedbackHotActivity feedbackHotActivity) {
        this.f3766a = feedbackHotActivity;
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
        view2 = this.f3766a.l;
        view2.setVisibility(0);
        linearLayout = this.f3766a.h;
        linearLayout.setVisibility(8);
        if (!com.baidu.ufosdk.b.d.b(this.f3766a.getApplicationContext()).contains(RomUtils.UNKNOWN) && !com.baidu.ufosdk.b.d.b(this.f3766a.getApplicationContext()).contains("NONE")) {
            this.f3766a.a();
            linearLayout3 = this.f3766a.h;
            linearLayout3.setVisibility(8);
            webView = this.f3766a.j;
            webView.setVisibility(0);
            return;
        }
        view3 = this.f3766a.l;
        view3.setVisibility(8);
        Context applicationContext = this.f3766a.getApplicationContext();
        textView = this.f3766a.m;
        com.baidu.ufosdk.f.i.a(applicationContext, textView);
        linearLayout2 = this.f3766a.h;
        linearLayout2.setVisibility(0);
    }
}
