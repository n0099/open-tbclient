package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes5.dex */
public final class bf implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f22775a;

    public bf(FeedbackInputActivity feedbackInputActivity) {
        this.f22775a = feedbackInputActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            if (!com.baidu.ufosdk.b.d.c(this.f22775a.getApplicationContext())) {
                com.baidu.ufosdk.f.c.b("Network is not avaiable!");
                return;
            }
            this.f22775a.f22709b.setVisibility(8);
            this.f22775a.k.setVisibility(0);
            if (this.f22775a.f22712e == null || this.f22775a.f22712e.length() <= 0) {
                return;
            }
            this.f22775a.l.execute(new bg(this));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
