package com.baidu.ufosdk.ui;

import android.content.Context;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes5.dex */
public final class dn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ dl f22867a;

    public dn(dl dlVar) {
        this.f22867a = dlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context applicationContext = this.f22867a.f22865a.getApplicationContext();
        String str = UfoSDK.clientid;
        com.baidu.ufosdk.e.a.b(applicationContext);
    }
}
