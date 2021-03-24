package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes5.dex */
public final class bf implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f23081a;

    public bf(FeedbackInputActivity feedbackInputActivity) {
        this.f23081a = feedbackInputActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            if (!com.baidu.ufosdk.b.d.c(this.f23081a.getApplicationContext())) {
                com.baidu.ufosdk.f.c.b("Network is not avaiable!");
                return;
            }
            this.f23081a.f23015b.setVisibility(8);
            this.f23081a.k.setVisibility(0);
            if (this.f23081a.f23018e == null || this.f23081a.f23018e.length() <= 0) {
                return;
            }
            this.f23081a.l.execute(new bg(this));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
