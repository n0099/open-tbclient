package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes5.dex */
public final class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackEditActivity f22983a;

    public v(FeedbackEditActivity feedbackEditActivity) {
        this.f22983a = feedbackEditActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        Context applicationContext = this.f22983a.getApplicationContext();
        String str = UfoSDK.clientid;
        String c2 = com.baidu.ufosdk.e.a.c(applicationContext);
        if (c2 != null) {
            handler = this.f22983a.af;
            handler.obtainMessage(0, c2).sendToTarget();
        }
    }
}
