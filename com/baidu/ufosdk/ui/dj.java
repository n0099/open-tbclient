package com.baidu.ufosdk.ui;

import android.content.Context;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes5.dex */
public final class dj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ dh f23178a;

    public dj(dh dhVar) {
        this.f23178a = dhVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context applicationContext = this.f23178a.f23176a.getApplicationContext();
        String str = UfoSDK.clientid;
        com.baidu.ufosdk.e.a.b(applicationContext);
    }
}
