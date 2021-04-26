package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
/* loaded from: classes5.dex */
public final class cv implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ cg f23539a;

    public cv(cg cgVar) {
        this.f23539a = cgVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            FeedbackInputActivity.f23415a = com.baidu.ufosdk.f.i.a(((ImageView) view).getDrawable());
            this.f23539a.f23518a.startActivity(new Intent(this.f23539a.f23518a, FeedbackImageViewFlipperActivity.class));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
