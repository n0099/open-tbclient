package com.baidu.webkit.logsdk.a;
/* loaded from: classes5.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.webkit.logsdk.c.a f3953a;
    final /* synthetic */ b b;

    public e(b bVar, com.baidu.webkit.logsdk.c.a aVar) {
        this.b = bVar;
        this.f3953a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.h().c().a(this.f3953a);
    }
}
