package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
class h extends com.baidu.adp.base.i {
    final /* synthetic */ PbActivity bIJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(PbActivity pbActivity) {
        this.bIJ = pbActivity;
    }

    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        cj cjVar;
        com.baidu.tieba.tbadkCore.h.a aVar;
        com.baidu.tieba.tbadkCore.h.a aVar2;
        com.baidu.tieba.tbadkCore.h.a aVar3;
        br brVar;
        if (obj != null) {
            aVar2 = this.bIJ.bIk;
            switch (aVar2.getLoadDataMode()) {
                case 0:
                    brVar = this.bIJ.bIg;
                    brVar.aao();
                    this.bIJ.a((com.baidu.tieba.tbadkCore.h.c) obj);
                    return;
                case 1:
                    this.bIJ.a((com.baidu.tieba.tbadkCore.h.e) obj);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    PbActivity pbActivity = this.bIJ;
                    aVar3 = this.bIJ.bIk;
                    pbActivity.a(aVar3.getLoadDataMode(), (com.baidu.tieba.tbadkCore.h.g) obj);
                    return;
                case 6:
                    this.bIJ.a((com.baidu.tieba.tbadkCore.h.g) obj);
                    return;
                default:
                    return;
            }
        }
        cjVar = this.bIJ.bIl;
        aVar = this.bIJ.bIk;
        cjVar.a(aVar.getLoadDataMode(), false, (String) null, false);
    }
}
