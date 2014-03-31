package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
final class cf implements Runnable {
    final /* synthetic */ ce a;
    private final /* synthetic */ com.baidu.tieba.data.an b;
    private final /* synthetic */ boolean c;
    private final /* synthetic */ String d;
    private final /* synthetic */ String e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(ce ceVar, com.baidu.tieba.data.an anVar, boolean z, String str, String str2) {
        this.a = ceVar;
        this.b = anVar;
        this.c = z;
        this.d = str;
        this.e = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        bk bkVar;
        cr crVar;
        bk bkVar2;
        bk bkVar3;
        com.baidu.tieba.pb.sub.m mVar;
        bk bkVar4;
        cr crVar2;
        bkVar = this.a.a;
        crVar = bkVar.aC;
        if (crVar != null) {
            bkVar4 = this.a.a;
            crVar2 = bkVar4.aC;
            com.baidu.tieba.data.an anVar = this.b;
            crVar2.a();
        }
        if (this.c) {
            bkVar3 = this.a.a;
            mVar = bkVar3.N;
            mVar.a(this.d, this.e);
        }
        bkVar2 = this.a.a;
        bkVar2.aj();
    }
}
