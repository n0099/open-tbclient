package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
class g extends com.baidu.adp.base.i {
    final /* synthetic */ PbActivity bKT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PbActivity pbActivity) {
        this.bKT = pbActivity;
    }

    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        ch chVar;
        com.baidu.tieba.tbadkCore.h.a aVar;
        com.baidu.tieba.tbadkCore.h.a aVar2;
        com.baidu.tieba.tbadkCore.h.a aVar3;
        bo boVar;
        if (obj != null) {
            aVar2 = this.bKT.bKy;
            switch (aVar2.getLoadDataMode()) {
                case 0:
                    boVar = this.bKT.bKv;
                    boVar.abC();
                    this.bKT.a((com.baidu.tieba.tbadkCore.h.c) obj);
                    return;
                case 1:
                    this.bKT.a((com.baidu.tieba.tbadkCore.h.e) obj);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    PbActivity pbActivity = this.bKT;
                    aVar3 = this.bKT.bKy;
                    pbActivity.a(aVar3.getLoadDataMode(), (com.baidu.tieba.tbadkCore.h.g) obj);
                    return;
                case 6:
                    this.bKT.a((com.baidu.tieba.tbadkCore.h.g) obj);
                    return;
                default:
                    return;
            }
        }
        chVar = this.bKT.bKz;
        aVar = this.bKT.bKy;
        chVar.a(aVar.getLoadDataMode(), false, (String) null, false);
    }
}
