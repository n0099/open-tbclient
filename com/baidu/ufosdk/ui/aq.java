package com.baidu.ufosdk.ui;

import android.content.Context;
import android.os.Handler;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes7.dex */
final class aq implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ao f5440a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ao aoVar) {
        this.f5440a = aoVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        Context applicationContext = this.f5440a.f5438a.getApplicationContext();
        String str = UfoSDK.clientid;
        String c = com.baidu.ufosdk.e.a.c(applicationContext);
        if (c != null) {
            handler = this.f5440a.f5438a.v;
            handler.obtainMessage(0, c).sendToTarget();
        }
    }
}
