package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
/* loaded from: classes5.dex */
public final class ch implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ cg f23520a;

    public ch(cg cgVar) {
        this.f23520a = cgVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            FeedbackInputActivity.f23415a = com.baidu.ufosdk.f.i.a(((ImageView) view).getDrawable());
            this.f23520a.f23518a.startActivity(new Intent(this.f23520a.f23518a, FeedbackImageViewFlipperActivity.class));
        } catch (Exception unused) {
        }
    }
}
