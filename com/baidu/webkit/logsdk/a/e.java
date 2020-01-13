package com.baidu.webkit.logsdk.a;
/* loaded from: classes10.dex */
public final class e implements Runnable {
    final /* synthetic */ com.baidu.webkit.logsdk.c.a a;
    final /* synthetic */ b b;

    public e(b bVar, com.baidu.webkit.logsdk.c.a aVar) {
        this.b = bVar;
        this.a = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.b.h().c().a(this.a);
    }
}
