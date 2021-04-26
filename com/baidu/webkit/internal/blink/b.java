package com.baidu.webkit.internal.blink;

import android.os.HandlerThread;
/* loaded from: classes5.dex */
public final class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ HandlerThread f27384a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f27385b;

    public b(a aVar, HandlerThread handlerThread) {
        this.f27385b = aVar;
        this.f27384a = handlerThread;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f27385b.a();
        this.f27384a.quit();
    }
}
