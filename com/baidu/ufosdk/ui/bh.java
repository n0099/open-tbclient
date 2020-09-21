package com.baidu.ufosdk.ui;
/* loaded from: classes21.dex */
final class bh implements Runnable {
    final /* synthetic */ FeedbackInputActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bh(FeedbackInputActivity feedbackInputActivity) {
        this.a = feedbackInputActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FeedbackInputActivity.g(this.a);
    }
}
