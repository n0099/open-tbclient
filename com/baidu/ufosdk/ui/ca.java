package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes21.dex */
final class ca implements View.OnClickListener {
    final /* synthetic */ FeedbackInputActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ca(FeedbackInputActivity feedbackInputActivity) {
        this.a = feedbackInputActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.a.D) {
            return;
        }
        if (this.a.p.getVisibility() == 0) {
            this.a.p.setVisibility(8);
            this.a.C.setVisibility(8);
            return;
        }
        if (this.a.p.getChildCount() <= 0) {
            this.a.a(true);
        }
        this.a.p.setVisibility(0);
        this.a.C.setVisibility(0);
    }
}
