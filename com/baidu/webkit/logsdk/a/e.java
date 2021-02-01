package com.baidu.webkit.logsdk.a;
/* loaded from: classes4.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.webkit.logsdk.c.a f5696a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ b f5697b;

    public e(b bVar, com.baidu.webkit.logsdk.c.a aVar) {
        this.f5697b = bVar;
        this.f5696a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5697b.h().c().a(this.f5696a);
    }
}
