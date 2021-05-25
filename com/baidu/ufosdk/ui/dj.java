package com.baidu.ufosdk.ui;

import android.content.Context;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes5.dex */
public final class dj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ dh f22756a;

    public dj(dh dhVar) {
        this.f22756a = dhVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context applicationContext = this.f22756a.f22754a.getApplicationContext();
        String str = UfoSDK.clientid;
        com.baidu.ufosdk.e.a.b(applicationContext);
    }
}
