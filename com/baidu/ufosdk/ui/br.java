package com.baidu.ufosdk.ui;

import android.os.Build;
import android.view.View;
/* loaded from: classes5.dex */
public final class br implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f23095a;

    public br(FeedbackInputActivity feedbackInputActivity) {
        this.f23095a = feedbackInputActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        FeedbackInputActivity feedbackInputActivity = this.f23095a;
        if (feedbackInputActivity.D) {
            return;
        }
        feedbackInputActivity.as = ((Integer) view.getTag()).intValue();
        if (Build.VERSION.SDK_INT >= 23) {
            com.baidu.ufosdk.f.c.d(" CommonUtil.getAPILevel() >= 23 ");
        }
        FeedbackInputActivity.l(this.f23095a);
    }
}
