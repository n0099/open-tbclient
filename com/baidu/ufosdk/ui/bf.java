package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes5.dex */
public final class bf implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f22762a;

    public bf(FeedbackInputActivity feedbackInputActivity) {
        this.f22762a = feedbackInputActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            if (!com.baidu.ufosdk.b.d.c(this.f22762a.getApplicationContext())) {
                com.baidu.ufosdk.f.c.b("Network is not avaiable!");
                return;
            }
            this.f22762a.f22693b.setVisibility(8);
            this.f22762a.k.setVisibility(0);
            if (this.f22762a.f22696e == null || this.f22762a.f22696e.length() <= 0) {
                return;
            }
            this.f22762a.l.execute(new bg(this));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
