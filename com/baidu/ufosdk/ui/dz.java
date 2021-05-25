package com.baidu.ufosdk.ui;

import android.os.Build;
import android.view.View;
/* loaded from: classes5.dex */
public final class dz implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackReportActivity f22777a;

    public dz(FeedbackReportActivity feedbackReportActivity) {
        this.f22777a = feedbackReportActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        boolean z;
        z = this.f22777a.B;
        if (z) {
            return;
        }
        this.f22777a.f22607a = ((Integer) view.getTag()).intValue();
        if (Build.VERSION.SDK_INT >= 23) {
            com.baidu.ufosdk.f.c.d(" CommonUtil.getAPILevel() >= 23 ");
        }
        FeedbackReportActivity.D(this.f22777a);
    }
}
