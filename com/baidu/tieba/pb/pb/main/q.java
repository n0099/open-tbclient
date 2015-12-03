package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.tbadkCore.f.a;
/* loaded from: classes.dex */
class q extends com.baidu.adp.base.g {
    final /* synthetic */ PbActivity cCm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PbActivity pbActivity) {
        this.cCm = pbActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        da daVar;
        com.baidu.tieba.tbadkCore.f.a aVar;
        com.baidu.tieba.tbadkCore.f.a aVar2;
        com.baidu.tieba.tbadkCore.f.a aVar3;
        cc ccVar;
        if (obj != null) {
            aVar2 = this.cCm.cBI;
            switch (aVar2.getLoadDataMode()) {
                case 0:
                    ccVar = this.cCm.cBG;
                    ccVar.akR();
                    this.cCm.a((a.b) obj);
                    return;
                case 1:
                    this.cCm.a((a.d) obj);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    PbActivity pbActivity = this.cCm;
                    aVar3 = this.cCm.cBI;
                    pbActivity.a(aVar3.getLoadDataMode(), (a.f) obj);
                    return;
                case 6:
                    this.cCm.a((a.f) obj);
                    return;
                default:
                    return;
            }
        }
        daVar = this.cCm.cBL;
        aVar = this.cCm.cBI;
        daVar.a(aVar.getLoadDataMode(), false, (String) null, false);
    }
}
