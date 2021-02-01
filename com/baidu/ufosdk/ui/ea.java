package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes8.dex */
final class ea implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackReportActivity f5552a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ea(FeedbackReportActivity feedbackReportActivity) {
        this.f5552a = feedbackReportActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f5552a.C = true;
        this.f5552a.a();
    }
}
