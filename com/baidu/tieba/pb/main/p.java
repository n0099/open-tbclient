package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
class p implements cz {
    final /* synthetic */ PbActivity bAT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PbActivity pbActivity) {
        this.bAT = pbActivity;
    }

    @Override // com.baidu.tieba.pb.main.cz
    public void a(com.baidu.tieba.tbadkCore.b.o oVar) {
        com.baidu.tieba.pb.sub.e eVar;
        com.baidu.tieba.pb.sub.e eVar2;
        bz bzVar;
        eVar = this.bAT.bAv;
        if (eVar != null) {
            eVar2 = this.bAT.bAv;
            if (eVar2.xL()) {
                bzVar = this.bAT.bAx;
                bzVar.YM();
            }
        }
    }
}
