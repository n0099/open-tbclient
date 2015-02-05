package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
class p implements cz {
    final /* synthetic */ PbActivity bAS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PbActivity pbActivity) {
        this.bAS = pbActivity;
    }

    @Override // com.baidu.tieba.pb.main.cz
    public void a(com.baidu.tieba.tbadkCore.b.o oVar) {
        com.baidu.tieba.pb.sub.e eVar;
        com.baidu.tieba.pb.sub.e eVar2;
        bz bzVar;
        eVar = this.bAS.bAu;
        if (eVar != null) {
            eVar2 = this.bAS.bAu;
            if (eVar2.xF()) {
                bzVar = this.bAS.bAw;
                bzVar.YH();
            }
        }
    }
}
