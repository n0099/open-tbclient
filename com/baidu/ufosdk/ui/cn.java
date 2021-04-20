package com.baidu.ufosdk.ui;

import android.os.Handler;
/* loaded from: classes5.dex */
public final class cn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ cm f22810a;

    public cn(cm cmVar) {
        this.f22810a = cmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        handler = this.f22810a.f22809a.f22800a.aK;
        com.baidu.ufosdk.e.a.a(handler);
    }
}
