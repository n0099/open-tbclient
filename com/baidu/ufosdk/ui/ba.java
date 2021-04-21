package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes5.dex */
public final class ba implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FeedbackHotActivity f22770a;

    public ba(FeedbackHotActivity feedbackHotActivity) {
        this.f22770a = feedbackHotActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        com.baidu.ufosdk.e.a.a(this.f22770a.getApplicationContext());
        Context applicationContext = this.f22770a.getApplicationContext();
        String str = UfoSDK.clientid;
        String c2 = com.baidu.ufosdk.e.a.c(applicationContext);
        if (c2 != null) {
            handler = this.f22770a.r;
            handler.obtainMessage(0, c2).sendToTarget();
        }
        this.f22770a.a();
    }
}
