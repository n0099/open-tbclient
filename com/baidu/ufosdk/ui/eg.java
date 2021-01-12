package com.baidu.ufosdk.ui;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public final class eg implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackReportActivity f5557a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eg(FeedbackReportActivity feedbackReportActivity) {
        this.f5557a = feedbackReportActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.baidu.ufosdk.e.a.a(this.f5557a.getApplicationContext());
    }
}
