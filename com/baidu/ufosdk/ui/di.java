package com.baidu.ufosdk.ui;

import android.content.Context;
import com.baidu.ufosdk.UfoSDK;
/* loaded from: classes8.dex */
final class di implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ dh f5810a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public di(dh dhVar) {
        this.f5810a = dhVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context applicationContext = this.f5810a.f5809a.getApplicationContext();
        String str = UfoSDK.clientid;
        com.baidu.ufosdk.e.a.b(applicationContext);
    }
}
