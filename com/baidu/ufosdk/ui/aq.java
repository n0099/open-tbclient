package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes8.dex */
final class aq implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ao f5722a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ao aoVar) {
        this.f5722a = aoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        Context applicationContext = this.f5722a.f5720a.getApplicationContext();
        String str = UfoSDK.clientid;
        String c = com.baidu.ufosdk.e.a.c(applicationContext);
        if (c != null) {
            handler = this.f5722a.f5720a.v;
            handler.obtainMessage(0, c).sendToTarget();
        }
    }
}
