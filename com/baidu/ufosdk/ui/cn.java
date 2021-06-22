package com.baidu.ufosdk.ui;

import android.os.Handler;
/* loaded from: classes5.dex */
public final class cn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ cm f22887a;

    public cn(cm cmVar) {
        this.f22887a = cmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        handler = this.f22887a.f22886a.f22877a.aK;
        com.baidu.ufosdk.e.a.a(handler);
    }
}
