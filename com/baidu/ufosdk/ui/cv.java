package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
/* loaded from: classes5.dex */
public final class cv implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ cg f22784a;

    public cv(cg cgVar) {
        this.f22784a = cgVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            FeedbackInputActivity.f22660a = com.baidu.ufosdk.f.i.a(((ImageView) view).getDrawable());
            this.f22784a.f22763a.startActivity(new Intent(this.f22784a.f22763a, FeedbackImageViewFlipperActivity.class));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
