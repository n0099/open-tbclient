package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
/* loaded from: classes5.dex */
public final class ch implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ cg f22802a;

    public ch(cg cgVar) {
        this.f22802a = cgVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            FeedbackInputActivity.f22700a = com.baidu.ufosdk.f.i.a(((ImageView) view).getDrawable());
            this.f22802a.f22800a.startActivity(new Intent(this.f22802a.f22800a, FeedbackImageViewFlipperActivity.class));
        } catch (Exception unused) {
        }
    }
}
