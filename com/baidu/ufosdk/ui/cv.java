package com.baidu.ufosdk.ui;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
/* loaded from: classes5.dex */
public final class cv implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ cg f23136a;

    public cv(cg cgVar) {
        this.f23136a = cgVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            FeedbackInputActivity.f23015a = com.baidu.ufosdk.f.i.a(((ImageView) view).getDrawable());
            this.f23136a.f23115a.startActivity(new Intent(this.f23136a.f23115a, FeedbackImageViewFlipperActivity.class));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
