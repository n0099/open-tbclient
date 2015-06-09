package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
class g extends com.baidu.adp.base.i {
    final /* synthetic */ PbActivity bKU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PbActivity pbActivity) {
        this.bKU = pbActivity;
    }

    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        ch chVar;
        com.baidu.tieba.tbadkCore.h.a aVar;
        com.baidu.tieba.tbadkCore.h.a aVar2;
        com.baidu.tieba.tbadkCore.h.a aVar3;
        bo boVar;
        if (obj != null) {
            aVar2 = this.bKU.bKz;
            switch (aVar2.getLoadDataMode()) {
                case 0:
                    boVar = this.bKU.bKw;
                    boVar.abD();
                    this.bKU.a((com.baidu.tieba.tbadkCore.h.c) obj);
                    return;
                case 1:
                    this.bKU.a((com.baidu.tieba.tbadkCore.h.e) obj);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    PbActivity pbActivity = this.bKU;
                    aVar3 = this.bKU.bKz;
                    pbActivity.a(aVar3.getLoadDataMode(), (com.baidu.tieba.tbadkCore.h.g) obj);
                    return;
                case 6:
                    this.bKU.a((com.baidu.tieba.tbadkCore.h.g) obj);
                    return;
                default:
                    return;
            }
        }
        chVar = this.bKU.bKA;
        aVar = this.bKU.bKz;
        chVar.a(aVar.getLoadDataMode(), false, (String) null, false);
    }
}
