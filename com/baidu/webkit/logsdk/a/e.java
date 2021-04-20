package com.baidu.webkit.logsdk.a;
/* loaded from: classes5.dex */
public final class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ com.baidu.webkit.logsdk.c.a f26668a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f26669b;

    public e(b bVar, com.baidu.webkit.logsdk.c.a aVar) {
        this.f26669b = bVar;
        this.f26668a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f26669b.h().c().a(this.f26668a);
    }
}
