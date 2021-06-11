package com.baidu.ufosdk.ui;

import android.os.Build;
import android.view.View;
/* loaded from: classes5.dex */
public final class dz implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackReportActivity f22880a;

    public dz(FeedbackReportActivity feedbackReportActivity) {
        this.f22880a = feedbackReportActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        z = this.f22880a.B;
        if (z) {
            return;
        }
        this.f22880a.f22710a = ((Integer) view.getTag()).intValue();
        if (Build.VERSION.SDK_INT >= 23) {
            com.baidu.ufosdk.f.c.d(" CommonUtil.getAPILevel() >= 23 ");
        }
        FeedbackReportActivity.D(this.f22880a);
    }
}
