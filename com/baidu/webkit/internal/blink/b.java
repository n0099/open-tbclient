package com.baidu.webkit.internal.blink;

import android.os.HandlerThread;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ HandlerThread f5951a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a f5952b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, HandlerThread handlerThread) {
        this.f5952b = aVar;
        this.f5951a = handlerThread;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5952b.a();
        this.f5951a.quit();
    }
}
