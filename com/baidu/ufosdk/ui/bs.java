package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes22.dex */
final class bs implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackInputActivity f3786a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bs(FeedbackInputActivity feedbackInputActivity) {
        this.f3786a = feedbackInputActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        Handler handler2;
        Handler handler3;
        com.baidu.ufosdk.e.a.a(this.f3786a.getApplicationContext());
        if (UfoSDK.clientid.length() != 0) {
            handler3 = this.f3786a.aK;
            handler3.obtainMessage(1, null).sendToTarget();
        } else {
            handler = this.f3786a.aK;
            handler.obtainMessage(4, null).sendToTarget();
        }
        Context applicationContext = this.f3786a.getApplicationContext();
        String str = UfoSDK.clientid;
        String c = com.baidu.ufosdk.e.a.c(applicationContext);
        if (c != null) {
            handler2 = this.f3786a.aK;
            handler2.obtainMessage(0, c).sendToTarget();
        }
    }
}
