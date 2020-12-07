package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes22.dex */
final class ea implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackReportActivity f3851a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ea(FeedbackReportActivity feedbackReportActivity) {
        this.f3851a = feedbackReportActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f3851a.C = true;
        this.f3851a.a();
    }
}
