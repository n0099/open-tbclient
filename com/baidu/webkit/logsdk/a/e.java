package com.baidu.webkit.logsdk.a;
/* loaded from: classes14.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.webkit.logsdk.c.a f5694a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ b f5695b;

    public e(b bVar, com.baidu.webkit.logsdk.c.a aVar) {
        this.f5695b = bVar;
        this.f5694a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5695b.h().c().a(this.f5694a);
    }
}
