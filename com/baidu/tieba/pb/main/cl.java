package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
class cl implements Runnable {
    final /* synthetic */ ck a;
    private final /* synthetic */ com.baidu.tieba.data.at b;
    private final /* synthetic */ boolean c;
    private final /* synthetic */ String d;
    private final /* synthetic */ String e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cl(ck ckVar, com.baidu.tieba.data.at atVar, boolean z, String str, String str2) {
        this.a = ckVar;
        this.b = atVar;
        this.c = z;
        this.d = str;
        this.e = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        bt btVar;
        cv cvVar;
        bt btVar2;
        bt btVar3;
        com.baidu.tieba.pb.sub.m mVar;
        bt btVar4;
        cv cvVar2;
        btVar = this.a.a;
        cvVar = btVar.aA;
        if (cvVar != null) {
            btVar4 = this.a.a;
            cvVar2 = btVar4.aA;
            cvVar2.a(this.b);
        }
        if (this.c) {
            btVar3 = this.a.a;
            mVar = btVar3.L;
            mVar.a(this.d, this.e);
        }
        btVar2 = this.a.a;
        btVar2.al();
    }
}
