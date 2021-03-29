package com.baidu.webkit.internal.blink;

import android.os.HandlerThread;
/* loaded from: classes5.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HandlerThread f26884a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f26885b;

    public b(a aVar, HandlerThread handlerThread) {
        this.f26885b = aVar;
        this.f26884a = handlerThread;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26885b.a();
        this.f26884a.quit();
    }
}
