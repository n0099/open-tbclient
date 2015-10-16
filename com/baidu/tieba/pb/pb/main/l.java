package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.tbadkCore.g.a;
/* loaded from: classes.dex */
class l extends com.baidu.adp.base.g {
    final /* synthetic */ PbActivity ciK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PbActivity pbActivity) {
        this.ciK = pbActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        cc ccVar;
        com.baidu.tieba.tbadkCore.g.a aVar;
        com.baidu.tieba.tbadkCore.g.a aVar2;
        com.baidu.tieba.tbadkCore.g.a aVar3;
        bl blVar;
        if (obj != null) {
            aVar2 = this.ciK.cij;
            switch (aVar2.getLoadDataMode()) {
                case 0:
                    blVar = this.ciK.cih;
                    blVar.afW();
                    this.ciK.a((a.b) obj);
                    return;
                case 1:
                    this.ciK.a((a.d) obj);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    PbActivity pbActivity = this.ciK;
                    aVar3 = this.ciK.cij;
                    pbActivity.a(aVar3.getLoadDataMode(), (a.f) obj);
                    return;
                case 6:
                    this.ciK.a((a.f) obj);
                    return;
                default:
                    return;
            }
        }
        ccVar = this.ciK.cim;
        aVar = this.ciK.cij;
        ccVar.a(aVar.getLoadDataMode(), false, (String) null, false);
    }
}
