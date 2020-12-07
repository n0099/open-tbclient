package com.baidu.ufosdk.ui;

import android.os.Build;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes22.dex */
public final class br implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f3788a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(FeedbackInputActivity feedbackInputActivity) {
        this.f3788a = feedbackInputActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (this.f3788a.D) {
            return;
        }
        this.f3788a.as = ((Integer) view.getTag()).intValue();
        if (Build.VERSION.SDK_INT >= 23) {
            com.baidu.ufosdk.f.c.d(" CommonUtil.getAPILevel() >= 23 ");
        }
        FeedbackInputActivity.l(this.f3788a);
    }
}
