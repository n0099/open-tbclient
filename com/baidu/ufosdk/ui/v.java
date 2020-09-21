package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes21.dex */
final class v implements Runnable {
    final /* synthetic */ FeedbackEditActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(FeedbackEditActivity feedbackEditActivity) {
        this.a = feedbackEditActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        Context applicationContext = this.a.getApplicationContext();
        String str = UfoSDK.clientid;
        String c = com.baidu.ufosdk.e.a.c(applicationContext);
        if (c != null) {
            handler = this.a.af;
            handler.obtainMessage(0, c).sendToTarget();
        }
    }
}
