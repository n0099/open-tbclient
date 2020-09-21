package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes21.dex */
final class bs implements Runnable {
    final /* synthetic */ FeedbackInputActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(FeedbackInputActivity feedbackInputActivity) {
        this.a = feedbackInputActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        com.baidu.ufosdk.e.a.a(this.a.getApplicationContext());
        if (UfoSDK.clientid.length() != 0) {
            handler3 = this.a.aK;
            handler3.obtainMessage(1, null).sendToTarget();
        } else {
            handler = this.a.aK;
            handler.obtainMessage(4, null).sendToTarget();
        }
        Context applicationContext = this.a.getApplicationContext();
        String str = UfoSDK.clientid;
        String c = com.baidu.ufosdk.e.a.c(applicationContext);
        if (c != null) {
            handler2 = this.a.aK;
            handler2.obtainMessage(0, c).sendToTarget();
        }
    }
}
