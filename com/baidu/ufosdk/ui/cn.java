package com.baidu.ufosdk.ui;

import android.os.Handler;
/* loaded from: classes8.dex */
final class cn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cm f5781a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(cm cmVar) {
        this.f5781a = cmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        handler = this.f5781a.f5780a.f5771a.aK;
        com.baidu.ufosdk.e.a.a(handler);
    }
}
