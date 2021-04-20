package com.baidu.webkit.internal.blink;

import android.os.HandlerThread;
/* loaded from: classes5.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HandlerThread f26569a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f26570b;

    public b(a aVar, HandlerThread handlerThread) {
        this.f26570b = aVar;
        this.f26569a = handlerThread;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26570b.a();
        this.f26569a.quit();
    }
}
