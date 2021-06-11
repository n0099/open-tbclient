package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
/* loaded from: classes5.dex */
public final class ch implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ cg f22797a;

    public ch(cg cgVar) {
        this.f22797a = cgVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            FeedbackInputActivity.f22692a = com.baidu.ufosdk.f.i.a(((ImageView) view).getDrawable());
            this.f22797a.f22795a.startActivity(new Intent(this.f22797a.f22795a, FeedbackImageViewFlipperActivity.class));
        } catch (Exception unused) {
        }
    }
}
