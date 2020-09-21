package com.baidu.ufosdk.ui;
/* loaded from: classes21.dex */
final class bo implements Runnable {
    final /* synthetic */ bm a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bo(bm bmVar) {
        this.a = bmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FeedbackInputActivity.j(this.a.b);
    }
}
