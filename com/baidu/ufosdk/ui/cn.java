package com.baidu.ufosdk.ui;

import android.os.Handler;
/* loaded from: classes22.dex */
final class cn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cm f3806a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(cm cmVar) {
        this.f3806a = cmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        handler = this.f3806a.f3805a.f3799a.aK;
        com.baidu.ufosdk.e.a.a(handler);
    }
}
