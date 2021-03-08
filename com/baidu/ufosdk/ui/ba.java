package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes7.dex */
final class ba implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ FeedbackHotActivity f3674a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(FeedbackHotActivity feedbackHotActivity) {
        this.f3674a = feedbackHotActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        com.baidu.ufosdk.e.a.a(this.f3674a.getApplicationContext());
        Context applicationContext = this.f3674a.getApplicationContext();
        String str = UfoSDK.clientid;
        String c = com.baidu.ufosdk.e.a.c(applicationContext);
        if (c != null) {
            handler = this.f3674a.r;
            handler.obtainMessage(0, c).sendToTarget();
        }
        this.f3674a.a();
    }
}
