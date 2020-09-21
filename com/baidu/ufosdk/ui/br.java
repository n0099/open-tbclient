package com.baidu.ufosdk.ui;

import android.os.Build;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes21.dex */
public final class br implements View.OnClickListener {
    final /* synthetic */ FeedbackInputActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(FeedbackInputActivity feedbackInputActivity) {
        this.a = feedbackInputActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.a.D) {
            return;
        }
        this.a.as = ((Integer) view.getTag()).intValue();
        if (Build.VERSION.SDK_INT >= 23) {
            com.baidu.ufosdk.f.c.d(" CommonUtil.getAPILevel() >= 23 ");
        }
        FeedbackInputActivity.l(this.a);
    }
}
