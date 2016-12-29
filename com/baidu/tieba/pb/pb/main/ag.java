package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.tbadkCore.f.a;
/* loaded from: classes.dex */
class ag extends com.baidu.adp.base.g {
    final /* synthetic */ PbActivity eah;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(PbActivity pbActivity) {
        this.eah = pbActivity;
    }

    @Override // com.baidu.adp.base.g
    public void g(Object obj) {
        er erVar;
        com.baidu.tieba.tbadkCore.f.a aVar;
        com.baidu.tieba.tbadkCore.f.a aVar2;
        com.baidu.tieba.tbadkCore.f.a aVar3;
        er erVar2;
        com.baidu.tieba.tbadkCore.f.a aVar4;
        er erVar3;
        er erVar4;
        dc dcVar;
        boolean z = false;
        if (obj != null) {
            aVar2 = this.eah.dZj;
            switch (aVar2.getLoadDataMode()) {
                case 0:
                    dcVar = this.eah.dYA;
                    dcVar.aKy();
                    a.b bVar = (a.b) obj;
                    if (bVar.cfs || bVar.ejf <= 0 || bVar.fiF == 0) {
                        z = true;
                    } else {
                        com.baidu.tieba.c.a.a(this.eah.getPageContext(), 2, 1);
                    }
                    this.eah.a(bVar, z);
                    return;
                case 1:
                    a.d dVar = (a.d) obj;
                    erVar4 = this.eah.dZk;
                    erVar4.a(1, dVar.uc, dVar.fiH, true);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    PbActivity pbActivity = this.eah;
                    aVar3 = this.eah.dZj;
                    pbActivity.a(aVar3.getLoadDataMode(), (a.f) obj);
                    return;
                case 6:
                    a.f fVar = (a.f) obj;
                    erVar2 = this.eah.dZk;
                    aVar4 = this.eah.dZj;
                    erVar2.a(aVar4.getLoadDataMode(), fVar.uc, fVar.fiH, false);
                    erVar3 = this.eah.dZk;
                    erVar3.ag(fVar.fiJ);
                    return;
                default:
                    return;
            }
        }
        erVar = this.eah.dZk;
        aVar = this.eah.dZj;
        erVar.a(aVar.getLoadDataMode(), false, (String) null, false);
    }
}
