package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes5.dex */
public final class aq implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ao f22713a;

    public aq(ao aoVar) {
        this.f22713a = aoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        Context applicationContext = this.f22713a.f22711a.getApplicationContext();
        String str = UfoSDK.clientid;
        String c2 = com.baidu.ufosdk.e.a.c(applicationContext);
        if (c2 != null) {
            handler = this.f22713a.f22711a.v;
            handler.obtainMessage(0, c2).sendToTarget();
        }
    }
}
