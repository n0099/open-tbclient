package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
class h extends com.baidu.adp.base.i {
    final /* synthetic */ PbActivity bAS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PbActivity pbActivity) {
        this.bAS = pbActivity;
    }

    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        bz bzVar;
        com.baidu.tieba.tbadkCore.e.a aVar;
        com.baidu.tieba.tbadkCore.e.a aVar2;
        com.baidu.tieba.tbadkCore.e.a aVar3;
        bq bqVar;
        if (obj != null) {
            aVar2 = this.bAS.bAv;
            switch (aVar2.getLoadDataMode()) {
                case 0:
                    bqVar = this.bAS.bAr;
                    bqVar.XS();
                    this.bAS.a((com.baidu.tieba.tbadkCore.e.c) obj);
                    return;
                case 1:
                    this.bAS.a((com.baidu.tieba.tbadkCore.e.e) obj);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    PbActivity pbActivity = this.bAS;
                    aVar3 = this.bAS.bAv;
                    pbActivity.a(aVar3.getLoadDataMode(), (com.baidu.tieba.tbadkCore.e.g) obj);
                    return;
                case 6:
                    this.bAS.a((com.baidu.tieba.tbadkCore.e.g) obj);
                    return;
                default:
                    return;
            }
        }
        bzVar = this.bAS.bAw;
        aVar = this.bAS.bAv;
        bzVar.a(aVar.getLoadDataMode(), false, (String) null, false);
    }
}
