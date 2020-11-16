package com.baidu.webkit.internal.blink;

import android.os.HandlerThread;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ HandlerThread f3927a;
    final /* synthetic */ a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar, HandlerThread handlerThread) {
        this.b = aVar;
        this.f3927a = handlerThread;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.a();
        this.f3927a.quit();
    }
}
