package com.baidu.webkit.logsdk.a;
/* loaded from: classes5.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.baidu.webkit.logsdk.c.a f26676a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f26677b;

    public e(b bVar, com.baidu.webkit.logsdk.c.a aVar) {
        this.f26677b = bVar;
        this.f26676a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26677b.h().c().a(this.f26676a);
    }
}
