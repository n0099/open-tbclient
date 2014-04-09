package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
final class ch implements Runnable {
    final /* synthetic */ cg a;
    private final /* synthetic */ com.baidu.tieba.data.am b;
    private final /* synthetic */ boolean c;
    private final /* synthetic */ String d;
    private final /* synthetic */ String e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(cg cgVar, com.baidu.tieba.data.am amVar, boolean z, String str, String str2) {
        this.a = cgVar;
        this.b = amVar;
        this.c = z;
        this.d = str;
        this.e = str2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        bm bmVar;
        ct ctVar;
        bm bmVar2;
        bm bmVar3;
        com.baidu.tieba.pb.sub.m mVar;
        bm bmVar4;
        ct ctVar2;
        bmVar = this.a.a;
        ctVar = bmVar.aC;
        if (ctVar != null) {
            bmVar4 = this.a.a;
            ctVar2 = bmVar4.aC;
            com.baidu.tieba.data.am amVar = this.b;
            ctVar2.a();
        }
        if (this.c) {
            bmVar3 = this.a.a;
            mVar = bmVar3.N;
            mVar.a(this.d, this.e);
        }
        bmVar2 = this.a.a;
        bmVar2.aj();
    }
}
