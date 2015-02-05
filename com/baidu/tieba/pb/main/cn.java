package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
class cn implements Runnable {
    private final /* synthetic */ com.baidu.tieba.tbadkCore.b.o bEE;
    private final /* synthetic */ boolean bEF;
    private final /* synthetic */ String bEG;
    private final /* synthetic */ String bEH;
    final /* synthetic */ cm bEI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(cm cmVar, com.baidu.tieba.tbadkCore.b.o oVar, boolean z, String str, String str2) {
        this.bEI = cmVar;
        this.bEE = oVar;
        this.bEF = z;
        this.bEG = str;
        this.bEH = str2;
    }

    @Override // java.lang.Runnable
    public void run() {
        bz bzVar;
        cz czVar;
        bz bzVar2;
        bz bzVar3;
        com.baidu.tieba.pb.sub.l lVar;
        bz bzVar4;
        cz czVar2;
        bzVar = this.bEI.bEB;
        czVar = bzVar.bDZ;
        if (czVar != null) {
            bzVar4 = this.bEI.bEB;
            czVar2 = bzVar4.bDZ;
            czVar2.a(this.bEE);
        }
        if (this.bEF) {
            bzVar3 = this.bEI.bEB;
            lVar = bzVar3.bDv;
            lVar.aO(this.bEG, this.bEH);
        }
        bzVar2 = this.bEI.bEB;
        bzVar2.Zh();
    }
}
