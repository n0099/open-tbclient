package com.baidu.ufosdk.ui;

import android.os.Build;
import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class dz implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackReportActivity f5547a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dz(FeedbackReportActivity feedbackReportActivity) {
        this.f5547a = feedbackReportActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        z = this.f5547a.B;
        if (z) {
            return;
        }
        this.f5547a.f5418a = ((Integer) view.getTag()).intValue();
        if (Build.VERSION.SDK_INT >= 23) {
            com.baidu.ufosdk.f.c.d(" CommonUtil.getAPILevel() >= 23 ");
        }
        FeedbackReportActivity.D(this.f5547a);
    }
}
