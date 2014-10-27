package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
class ck implements Runnable {
    private final /* synthetic */ com.baidu.tieba.data.ar byL;
    private final /* synthetic */ boolean byM;
    private final /* synthetic */ String byN;
    private final /* synthetic */ String byO;
    final /* synthetic */ cj byP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ck(cj cjVar, com.baidu.tieba.data.ar arVar, boolean z, String str, String str2) {
        this.byP = cjVar;
        this.byL = arVar;
        this.byM = z;
        this.byN = str;
        this.byO = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        bv bvVar;
        cw cwVar;
        bv bvVar2;
        bv bvVar3;
        com.baidu.tieba.pb.sub.l lVar;
        bv bvVar4;
        cw cwVar2;
        bvVar = this.byP.byI;
        cwVar = bvVar.byi;
        if (cwVar != null) {
            bvVar4 = this.byP.byI;
            cwVar2 = bvVar4.byi;
            cwVar2.a(this.byL);
        }
        if (this.byM) {
            bvVar3 = this.byP.byI;
            lVar = bvVar3.bxG;
            lVar.aB(this.byN, this.byO);
        }
        bvVar2 = this.byP.byI;
        bvVar2.Yg();
    }
}
