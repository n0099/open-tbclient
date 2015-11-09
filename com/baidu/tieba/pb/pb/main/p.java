package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.tbadkCore.h.a;
/* loaded from: classes.dex */
class p extends com.baidu.adp.base.g {
    final /* synthetic */ PbActivity cjN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PbActivity pbActivity) {
        this.cjN = pbActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        ct ctVar;
        com.baidu.tieba.tbadkCore.h.a aVar;
        com.baidu.tieba.tbadkCore.h.a aVar2;
        com.baidu.tieba.tbadkCore.h.a aVar3;
        ca caVar;
        if (obj != null) {
            aVar2 = this.cjN.cjl;
            switch (aVar2.getLoadDataMode()) {
                case 0:
                    caVar = this.cjN.cjj;
                    caVar.agx();
                    this.cjN.a((a.b) obj);
                    return;
                case 1:
                    this.cjN.a((a.d) obj);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    PbActivity pbActivity = this.cjN;
                    aVar3 = this.cjN.cjl;
                    pbActivity.a(aVar3.getLoadDataMode(), (a.f) obj);
                    return;
                case 6:
                    this.cjN.a((a.f) obj);
                    return;
                default:
                    return;
            }
        }
        ctVar = this.cjN.cjo;
        aVar = this.cjN.cjl;
        ctVar.a(aVar.getLoadDataMode(), false, (String) null, false);
    }
}
