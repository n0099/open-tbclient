package com.baidu.ufosdk.ui;

import android.content.Context;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes7.dex */
final class dj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ dh f3736a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dj(dh dhVar) {
        this.f3736a = dhVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context applicationContext = this.f3736a.f3734a.getApplicationContext();
        String str = UfoSDK.clientid;
        com.baidu.ufosdk.e.a.b(applicationContext);
    }
}
