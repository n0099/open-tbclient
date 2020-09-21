package com.baidu.ufosdk.ui;
/* loaded from: classes21.dex */
final class dr implements Runnable {
    final /* synthetic */ FeedbackListActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dr(FeedbackListActivity feedbackListActivity) {
        this.a = feedbackListActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        com.baidu.ufosdk.e.a.a(this.a.getApplicationContext());
    }
}
