package com.baidu.ufosdk.ui;

import android.content.Context;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes5.dex */
public final class dn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ dl f22831a;

    public dn(dl dlVar) {
        this.f22831a = dlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context applicationContext = this.f22831a.f22829a.getApplicationContext();
        String str = UfoSDK.clientid;
        com.baidu.ufosdk.e.a.b(applicationContext);
    }
}
