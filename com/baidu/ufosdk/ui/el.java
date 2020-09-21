package com.baidu.ufosdk.ui;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes21.dex */
public final class el implements Runnable {
    final /* synthetic */ FeedbackInputActivity a;
    final /* synthetic */ ej b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public el(ej ejVar, FeedbackInputActivity feedbackInputActivity) {
        this.b = ejVar;
        this.a = feedbackInputActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.getApplicationContext();
        com.baidu.ufosdk.e.a.a(this.a.f, 9);
    }
}
