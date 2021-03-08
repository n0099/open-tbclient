package com.baidu.ufosdk.ui;

import android.content.Context;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes7.dex */
final class dn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ dl f3740a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dn(dl dlVar) {
        this.f3740a = dlVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context applicationContext = this.f3740a.f3738a.getApplicationContext();
        String str = UfoSDK.clientid;
        com.baidu.ufosdk.e.a.b(applicationContext);
    }
}
