package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
class cl implements Runnable {
    final /* synthetic */ ck a;
    private final /* synthetic */ com.baidu.tieba.data.ap b;
    private final /* synthetic */ boolean c;
    private final /* synthetic */ String d;
    private final /* synthetic */ String e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(ck ckVar, com.baidu.tieba.data.ap apVar, boolean z, String str, String str2) {
        this.a = ckVar;
        this.b = apVar;
        this.c = z;
        this.d = str;
        this.e = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        bq bqVar;
        cw cwVar;
        bq bqVar2;
        bq bqVar3;
        com.baidu.tieba.pb.sub.m mVar;
        bq bqVar4;
        cw cwVar2;
        bqVar = this.a.a;
        cwVar = bqVar.aC;
        if (cwVar != null) {
            bqVar4 = this.a.a;
            cwVar2 = bqVar4.aC;
            cwVar2.a(this.b);
        }
        if (this.c) {
            bqVar3 = this.a.a;
            mVar = bqVar3.N;
            mVar.a(this.d, this.e);
        }
        bqVar2 = this.a.a;
        bqVar2.al();
    }
}
