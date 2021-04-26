package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes5.dex */
public final class bs implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackInputActivity f23500a;

    public bs(FeedbackInputActivity feedbackInputActivity) {
        this.f23500a = feedbackInputActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        int i2;
        Handler handler2;
        com.baidu.ufosdk.e.a.a(this.f23500a.getApplicationContext());
        if (UfoSDK.clientid.length() != 0) {
            handler = this.f23500a.aK;
            i2 = 1;
        } else {
            handler = this.f23500a.aK;
            i2 = 4;
        }
        handler.obtainMessage(i2, null).sendToTarget();
        Context applicationContext = this.f23500a.getApplicationContext();
        String str = UfoSDK.clientid;
        String c2 = com.baidu.ufosdk.e.a.c(applicationContext);
        if (c2 != null) {
            handler2 = this.f23500a.aK;
            handler2.obtainMessage(0, c2).sendToTarget();
        }
    }
}
