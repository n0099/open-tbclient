package com.baidu.ufosdk.ui;

import android.os.Handler;
/* loaded from: classes5.dex */
public final class cn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ cm f23528a;

    public cn(cm cmVar) {
        this.f23528a = cmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        handler = this.f23528a.f23527a.f23518a.aK;
        com.baidu.ufosdk.e.a.a(handler);
    }
}
