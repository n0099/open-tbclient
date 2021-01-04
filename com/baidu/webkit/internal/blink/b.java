package com.baidu.webkit.internal.blink;

import android.os.HandlerThread;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ HandlerThread f5950a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a f5951b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, HandlerThread handlerThread) {
        this.f5951b = aVar;
        this.f5950a = handlerThread;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5951b.a();
        this.f5950a.quit();
    }
}
