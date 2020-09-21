package com.baidu.ufosdk.ui;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes21.dex */
public final class eg implements Runnable {
    final /* synthetic */ FeedbackReportActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eg(FeedbackReportActivity feedbackReportActivity) {
        this.a = feedbackReportActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.baidu.ufosdk.e.a.a(this.a.getApplicationContext());
    }
}
