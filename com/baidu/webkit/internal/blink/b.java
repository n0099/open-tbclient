package com.baidu.webkit.internal.blink;

import android.os.HandlerThread;
/* loaded from: classes5.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HandlerThread f26883a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f26884b;

    public b(a aVar, HandlerThread handlerThread) {
        this.f26884b = aVar;
        this.f26883a = handlerThread;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26884b.a();
        this.f26883a.quit();
    }
}
