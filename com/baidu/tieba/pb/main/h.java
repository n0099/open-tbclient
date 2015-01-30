package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
class h extends com.baidu.adp.base.i {
    final /* synthetic */ PbActivity bAT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PbActivity pbActivity) {
        this.bAT = pbActivity;
    }

    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        bz bzVar;
        com.baidu.tieba.tbadkCore.e.a aVar;
        com.baidu.tieba.tbadkCore.e.a aVar2;
        com.baidu.tieba.tbadkCore.e.a aVar3;
        bq bqVar;
        if (obj != null) {
            aVar2 = this.bAT.bAw;
            switch (aVar2.getLoadDataMode()) {
                case 0:
                    bqVar = this.bAT.bAs;
                    bqVar.XX();
                    this.bAT.a((com.baidu.tieba.tbadkCore.e.c) obj);
                    return;
                case 1:
                    this.bAT.a((com.baidu.tieba.tbadkCore.e.e) obj);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    PbActivity pbActivity = this.bAT;
                    aVar3 = this.bAT.bAw;
                    pbActivity.a(aVar3.getLoadDataMode(), (com.baidu.tieba.tbadkCore.e.g) obj);
                    return;
                case 6:
                    this.bAT.a((com.baidu.tieba.tbadkCore.e.g) obj);
                    return;
                default:
                    return;
            }
        }
        bzVar = this.bAT.bAx;
        aVar = this.bAT.bAw;
        bzVar.a(aVar.getLoadDataMode(), false, (String) null, false);
    }
}
