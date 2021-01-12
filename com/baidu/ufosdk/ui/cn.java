package com.baidu.ufosdk.ui;

import android.os.Handler;
/* loaded from: classes7.dex */
final class cn implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cm f5499a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(cm cmVar) {
        this.f5499a = cmVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Handler handler;
        handler = this.f5499a.f5498a.f5489a.aK;
        com.baidu.ufosdk.e.a.a(handler);
    }
}
