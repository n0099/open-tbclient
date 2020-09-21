package com.baidu.ufosdk.ui;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes21.dex */
public final class bb implements Runnable {
    final /* synthetic */ FeedbackHotActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(FeedbackHotActivity feedbackHotActivity) {
        this.a = feedbackHotActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.baidu.ufosdk.e.a.a(this.a.getApplicationContext());
    }
}
