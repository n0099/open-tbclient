package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
class g extends com.baidu.adp.base.i {
    final /* synthetic */ PbActivity bzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PbActivity pbActivity) {
        this.bzj = pbActivity;
    }

    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        bz bzVar;
        com.baidu.tieba.tbadkCore.e.a aVar;
        com.baidu.tieba.tbadkCore.e.a aVar2;
        com.baidu.tieba.tbadkCore.e.a aVar3;
        bq bqVar;
        if (obj != null) {
            aVar2 = this.bzj.byN;
            switch (aVar2.getLoadDataMode()) {
                case 0:
                    bqVar = this.bzj.byJ;
                    bqVar.Xs();
                    this.bzj.a((com.baidu.tieba.tbadkCore.e.c) obj);
                    return;
                case 1:
                    this.bzj.a((com.baidu.tieba.tbadkCore.e.e) obj);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    PbActivity pbActivity = this.bzj;
                    aVar3 = this.bzj.byN;
                    pbActivity.a(aVar3.getLoadDataMode(), (com.baidu.tieba.tbadkCore.e.g) obj);
                    return;
                case 6:
                    this.bzj.a((com.baidu.tieba.tbadkCore.e.g) obj);
                    return;
                default:
                    return;
            }
        }
        bzVar = this.bzj.byO;
        aVar = this.bzj.byN;
        bzVar.a(aVar.getLoadDataMode(), false, (String) null, false);
    }
}
