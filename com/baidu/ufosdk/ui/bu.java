package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes22.dex */
final class bu implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f3788a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bu(FeedbackInputActivity feedbackInputActivity) {
        this.f3788a = feedbackInputActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        Context applicationContext = this.f3788a.getApplicationContext();
        String str = UfoSDK.clientid;
        String c = com.baidu.ufosdk.e.a.c(applicationContext);
        if (c != null) {
            handler = this.f3788a.aK;
            handler.obtainMessage(0, c).sendToTarget();
        }
    }
}
