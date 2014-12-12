package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
class co implements Runnable {
    private final /* synthetic */ com.baidu.tieba.tbadkCore.b.o bCV;
    private final /* synthetic */ boolean bCW;
    private final /* synthetic */ String bCX;
    private final /* synthetic */ String bCY;
    final /* synthetic */ cn bCZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(cn cnVar, com.baidu.tieba.tbadkCore.b.o oVar, boolean z, String str, String str2) {
        this.bCZ = cnVar;
        this.bCV = oVar;
        this.bCW = z;
        this.bCX = str;
        this.bCY = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        bz bzVar;
        da daVar;
        bz bzVar2;
        bz bzVar3;
        com.baidu.tieba.pb.sub.l lVar;
        bz bzVar4;
        da daVar2;
        bzVar = this.bCZ.bCR;
        daVar = bzVar.bCp;
        if (daVar != null) {
            bzVar4 = this.bCZ.bCR;
            daVar2 = bzVar4.bCp;
            daVar2.a(this.bCV);
        }
        if (this.bCW) {
            bzVar3 = this.bCZ.bCR;
            lVar = bzVar3.bBL;
            lVar.aL(this.bCX, this.bCY);
        }
        bzVar2 = this.bCZ.bCR;
        bzVar2.YH();
    }
}
