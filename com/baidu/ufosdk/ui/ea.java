package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes5.dex */
public final class ea implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackReportActivity f22967a;

    public ea(FeedbackReportActivity feedbackReportActivity) {
        this.f22967a = feedbackReportActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f22967a.C = true;
        this.f22967a.a();
    }
}
