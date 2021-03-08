package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes7.dex */
final class bf implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f3679a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(FeedbackInputActivity feedbackInputActivity) {
        this.f3679a = feedbackInputActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            if (com.baidu.ufosdk.b.d.c(this.f3679a.getApplicationContext())) {
                this.f3679a.b.setVisibility(8);
                this.f3679a.k.setVisibility(0);
                if (this.f3679a.e != null && this.f3679a.e.length() > 0) {
                    this.f3679a.l.execute(new bg(this));
                }
            } else {
                com.baidu.ufosdk.f.c.b("Network is not avaiable!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
