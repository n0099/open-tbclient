package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
class g extends com.baidu.adp.base.i {
    final /* synthetic */ PbActivity bIv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(PbActivity pbActivity) {
        this.bIv = pbActivity;
    }

    @Override // com.baidu.adp.base.i
    public void c(Object obj) {
        ci ciVar;
        com.baidu.tieba.tbadkCore.h.a aVar;
        com.baidu.tieba.tbadkCore.h.a aVar2;
        com.baidu.tieba.tbadkCore.h.a aVar3;
        bq bqVar;
        if (obj != null) {
            aVar2 = this.bIv.bHX;
            switch (aVar2.getLoadDataMode()) {
                case 0:
                    bqVar = this.bIv.bHT;
                    bqVar.aab();
                    this.bIv.a((com.baidu.tieba.tbadkCore.h.c) obj);
                    return;
                case 1:
                    this.bIv.a((com.baidu.tieba.tbadkCore.h.e) obj);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    PbActivity pbActivity = this.bIv;
                    aVar3 = this.bIv.bHX;
                    pbActivity.a(aVar3.getLoadDataMode(), (com.baidu.tieba.tbadkCore.h.g) obj);
                    return;
                case 6:
                    this.bIv.a((com.baidu.tieba.tbadkCore.h.g) obj);
                    return;
                default:
                    return;
            }
        }
        ciVar = this.bIv.bHY;
        aVar = this.bIv.bHX;
        ciVar.a(aVar.getLoadDataMode(), false, (String) null, false);
    }
}
