package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
class cn implements Runnable {
    private final /* synthetic */ com.baidu.tieba.tbadkCore.b.o bEF;
    private final /* synthetic */ boolean bEG;
    private final /* synthetic */ String bEH;
    private final /* synthetic */ String bEI;
    final /* synthetic */ cm bEJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(cm cmVar, com.baidu.tieba.tbadkCore.b.o oVar, boolean z, String str, String str2) {
        this.bEJ = cmVar;
        this.bEF = oVar;
        this.bEG = z;
        this.bEH = str;
        this.bEI = str2;
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
        bzVar = this.bEJ.bEC;
        czVar = bzVar.bEa;
        if (czVar != null) {
            bzVar4 = this.bEJ.bEC;
            czVar2 = bzVar4.bEa;
            czVar2.a(this.bEF);
        }
        if (this.bEG) {
            bzVar3 = this.bEJ.bEC;
            lVar = bzVar3.bDw;
            lVar.aO(this.bEH, this.bEI);
        }
        bzVar2 = this.bEJ.bEC;
        bzVar2.Zm();
    }
}
