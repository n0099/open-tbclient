package com.baidu.ufosdk.ui;

import android.content.Context;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes5.dex */
public final class dn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ dl f23181a;

    public dn(dl dlVar) {
        this.f23181a = dlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context applicationContext = this.f23181a.f23179a.getApplicationContext();
        String str = UfoSDK.clientid;
        com.baidu.ufosdk.e.a.b(applicationContext);
    }
}
