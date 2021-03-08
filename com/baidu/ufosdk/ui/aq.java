package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes7.dex */
final class aq implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ao f3663a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ao aoVar) {
        this.f3663a = aoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        Context applicationContext = this.f3663a.f3661a.getApplicationContext();
        String str = UfoSDK.clientid;
        String c = com.baidu.ufosdk.e.a.c(applicationContext);
        if (c != null) {
            handler = this.f3663a.f3661a.v;
            handler.obtainMessage(0, c).sendToTarget();
        }
    }
}
