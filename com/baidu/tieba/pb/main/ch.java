package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
class ch implements Runnable {
    final /* synthetic */ cg a;
    private final /* synthetic */ com.baidu.tieba.data.au b;
    private final /* synthetic */ boolean c;
    private final /* synthetic */ String d;
    private final /* synthetic */ String e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ch(cg cgVar, com.baidu.tieba.data.au auVar, boolean z, String str, String str2) {
        this.a = cgVar;
        this.b = auVar;
        this.c = z;
        this.d = str;
        this.e = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        bs bsVar;
        cu cuVar;
        bs bsVar2;
        bs bsVar3;
        com.baidu.tieba.pb.sub.l lVar;
        bs bsVar4;
        cu cuVar2;
        bsVar = this.a.a;
        cuVar = bsVar.aB;
        if (cuVar != null) {
            bsVar4 = this.a.a;
            cuVar2 = bsVar4.aB;
            cuVar2.a(this.b);
        }
        if (this.c) {
            bsVar3 = this.a.a;
            lVar = bsVar3.M;
            lVar.a(this.d, this.e);
        }
        bsVar2 = this.a.a;
        bsVar2.al();
    }
}
