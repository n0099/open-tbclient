package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes22.dex */
final class aq implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ao f3760a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ao aoVar) {
        this.f3760a = aoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        Context applicationContext = this.f3760a.f3758a.getApplicationContext();
        String str = UfoSDK.clientid;
        String c = com.baidu.ufosdk.e.a.c(applicationContext);
        if (c != null) {
            handler = this.f3760a.f3758a.v;
            handler.obtainMessage(0, c).sendToTarget();
        }
    }
}
