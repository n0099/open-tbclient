package com.baidu.ufosdk.ui;

import android.view.View;
/* loaded from: classes21.dex */
final class ea implements View.OnClickListener {
    final /* synthetic */ FeedbackReportActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ea(FeedbackReportActivity feedbackReportActivity) {
        this.a = feedbackReportActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.a.C = true;
        this.a.a();
    }
}
