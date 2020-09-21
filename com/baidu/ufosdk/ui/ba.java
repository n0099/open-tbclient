package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes21.dex */
final class ba implements Runnable {
    final /* synthetic */ FeedbackHotActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(FeedbackHotActivity feedbackHotActivity) {
        this.a = feedbackHotActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        com.baidu.ufosdk.e.a.a(this.a.getApplicationContext());
        Context applicationContext = this.a.getApplicationContext();
        String str = UfoSDK.clientid;
        String c = com.baidu.ufosdk.e.a.c(applicationContext);
        if (c != null) {
            handler = this.a.r;
            handler.obtainMessage(0, c).sendToTarget();
        }
        this.a.a();
    }
}
