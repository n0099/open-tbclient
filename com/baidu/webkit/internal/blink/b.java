package com.baidu.webkit.internal.blink;

import android.os.HandlerThread;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ HandlerThread f5653a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ a f5654b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, HandlerThread handlerThread) {
        this.f5654b = aVar;
        this.f5653a = handlerThread;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5654b.a();
        this.f5653a.quit();
    }
}
