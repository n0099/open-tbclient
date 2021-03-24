package com.baidu.ufosdk.ui;

import android.os.Build;
import android.view.View;
/* loaded from: classes5.dex */
public final class dz implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackReportActivity f23198a;

    public dz(FeedbackReportActivity feedbackReportActivity) {
        this.f23198a = feedbackReportActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        z = this.f23198a.B;
        if (z) {
            return;
        }
        this.f23198a.f23030a = ((Integer) view.getTag()).intValue();
        if (Build.VERSION.SDK_INT >= 23) {
            com.baidu.ufosdk.f.c.d(" CommonUtil.getAPILevel() >= 23 ");
        }
        FeedbackReportActivity.D(this.f23198a);
    }
}
