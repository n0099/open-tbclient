package com.baidu.ufosdk.ui;

import android.content.Context;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes8.dex */
final class dn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ dl f5815a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dn(dl dlVar) {
        this.f5815a = dlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context applicationContext = this.f5815a.f5813a.getApplicationContext();
        String str = UfoSDK.clientid;
        com.baidu.ufosdk.e.a.b(applicationContext);
    }
}
