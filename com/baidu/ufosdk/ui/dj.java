package com.baidu.ufosdk.ui;

import android.content.Context;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes5.dex */
public final class dj implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ dh f22863a;

    public dj(dh dhVar) {
        this.f22863a = dhVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context applicationContext = this.f22863a.f22861a.getApplicationContext();
        String str = UfoSDK.clientid;
        com.baidu.ufosdk.e.a.b(applicationContext);
    }
}
