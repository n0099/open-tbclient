package com.baidu.ufosdk.ui;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes21.dex */
public final class bl implements Runnable {
    final /* synthetic */ FeedbackInputActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bl(FeedbackInputActivity feedbackInputActivity) {
        this.a = feedbackInputActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FeedbackInputActivity.j(this.a);
    }
}
