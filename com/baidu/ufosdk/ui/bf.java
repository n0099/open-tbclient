package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes8.dex */
final class bf implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f5740a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(FeedbackInputActivity feedbackInputActivity) {
        this.f5740a = feedbackInputActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        try {
            if (com.baidu.ufosdk.b.d.c(this.f5740a.getApplicationContext())) {
                this.f5740a.f5698b.setVisibility(8);
                this.f5740a.k.setVisibility(0);
                if (this.f5740a.e != null && this.f5740a.e.length() > 0) {
                    this.f5740a.l.execute(new bg(this));
                }
            } else {
                com.baidu.ufosdk.f.c.b("Network is not avaiable!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
