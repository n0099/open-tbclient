package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes21.dex */
final class bf implements View.OnClickListener {
    final /* synthetic */ FeedbackInputActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(FeedbackInputActivity feedbackInputActivity) {
        this.a = feedbackInputActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            if (com.baidu.ufosdk.b.d.c(this.a.getApplicationContext())) {
                this.a.b.setVisibility(8);
                this.a.k.setVisibility(0);
                if (this.a.e != null && this.a.e.length() > 0) {
                    this.a.l.execute(new bg(this));
                }
            } else {
                com.baidu.ufosdk.f.c.b("Network is not avaiable!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
