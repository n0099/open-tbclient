package com.baidu.ufosdk.ui;

import android.os.Handler;
/* loaded from: classes21.dex */
final class w implements Runnable {
    final /* synthetic */ FeedbackEditActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(FeedbackEditActivity feedbackEditActivity) {
        this.a = feedbackEditActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        Handler handler;
        i = this.a.Y;
        handler = this.a.af;
        com.baidu.ufosdk.e.a.a(0, i, handler);
    }
}
