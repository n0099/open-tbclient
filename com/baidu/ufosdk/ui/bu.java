package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes5.dex */
public final class bu implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f22861a;

    public bu(FeedbackInputActivity feedbackInputActivity) {
        this.f22861a = feedbackInputActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        Context applicationContext = this.f22861a.getApplicationContext();
        String str = UfoSDK.clientid;
        String c2 = com.baidu.ufosdk.e.a.c(applicationContext);
        if (c2 != null) {
            handler = this.f22861a.aK;
            handler.obtainMessage(0, c2).sendToTarget();
        }
    }
}
