package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes8.dex */
final class v implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackEditActivity f5896a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(FeedbackEditActivity feedbackEditActivity) {
        this.f5896a = feedbackEditActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        Context applicationContext = this.f5896a.getApplicationContext();
        String str = UfoSDK.clientid;
        String c = com.baidu.ufosdk.e.a.c(applicationContext);
        if (c != null) {
            handler = this.f5896a.af;
            handler.obtainMessage(0, c).sendToTarget();
        }
    }
}
