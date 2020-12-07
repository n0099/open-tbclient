package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes22.dex */
final class bf implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f3776a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(FeedbackInputActivity feedbackInputActivity) {
        this.f3776a = feedbackInputActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            if (com.baidu.ufosdk.b.d.c(this.f3776a.getApplicationContext())) {
                this.f3776a.b.setVisibility(8);
                this.f3776a.k.setVisibility(0);
                if (this.f3776a.e != null && this.f3776a.e.length() > 0) {
                    this.f3776a.l.execute(new bg(this));
                }
            } else {
                com.baidu.ufosdk.f.c.b("Network is not avaiable!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
