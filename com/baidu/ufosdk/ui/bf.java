package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes7.dex */
final class bf implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f5457a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(FeedbackInputActivity feedbackInputActivity) {
        this.f5457a = feedbackInputActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            if (com.baidu.ufosdk.b.d.c(this.f5457a.getApplicationContext())) {
                this.f5457a.f5415b.setVisibility(8);
                this.f5457a.k.setVisibility(0);
                if (this.f5457a.e != null && this.f5457a.e.length() > 0) {
                    this.f5457a.l.execute(new bg(this));
                }
            } else {
                com.baidu.ufosdk.f.c.b("Network is not avaiable!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
