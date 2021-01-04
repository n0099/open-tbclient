package com.baidu.webkit.logsdk.a;
/* loaded from: classes4.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.webkit.logsdk.c.a f5993a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ b f5994b;

    public e(b bVar, com.baidu.webkit.logsdk.c.a aVar) {
        this.f5994b = bVar;
        this.f5993a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f5994b.h().c().a(this.f5993a);
    }
}
