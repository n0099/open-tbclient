package com.baidu.webkit.logsdk.a;
/* loaded from: classes15.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.webkit.logsdk.c.a f5994a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ b f5995b;

    public e(b bVar, com.baidu.webkit.logsdk.c.a aVar) {
        this.f5995b = bVar;
        this.f5994a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5995b.h().c().a(this.f5994a);
    }
}
