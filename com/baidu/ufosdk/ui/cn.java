package com.baidu.ufosdk.ui;

import android.os.Handler;
/* loaded from: classes5.dex */
public final class cn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ cm f23124a;

    public cn(cm cmVar) {
        this.f23124a = cmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        handler = this.f23124a.f23123a.f23114a.aK;
        com.baidu.ufosdk.e.a.a(handler);
    }
}
