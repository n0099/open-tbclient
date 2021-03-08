package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes7.dex */
final class ea implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackReportActivity f3754a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ea(FeedbackReportActivity feedbackReportActivity) {
        this.f3754a = feedbackReportActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f3754a.C = true;
        this.f3754a.a();
    }
}
