package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.tbadkCore.f.a;
/* loaded from: classes.dex */
class ah extends com.baidu.adp.base.g {
    final /* synthetic */ PbActivity evL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(PbActivity pbActivity) {
        this.evL = pbActivity;
    }

    @Override // com.baidu.adp.base.g
    public void g(Object obj) {
        ey eyVar;
        com.baidu.tieba.tbadkCore.f.a aVar;
        com.baidu.tieba.tbadkCore.f.a aVar2;
        com.baidu.tieba.tbadkCore.f.a aVar3;
        ey eyVar2;
        com.baidu.tieba.tbadkCore.f.a aVar4;
        ey eyVar3;
        ey eyVar4;
        dj djVar;
        boolean z = false;
        if (obj != null) {
            aVar2 = this.evL.euO;
            switch (aVar2.getLoadDataMode()) {
                case 0:
                    djVar = this.evL.euf;
                    djVar.aQB();
                    a.b bVar = (a.b) obj;
                    if (bVar.cAf || bVar.eFf <= 0 || bVar.fEy == 0) {
                        z = true;
                    } else {
                        com.baidu.tieba.c.a.a(this.evL.getPageContext(), 2, 1);
                    }
                    this.evL.a(bVar, z);
                    return;
                case 1:
                    a.d dVar = (a.d) obj;
                    eyVar4 = this.evL.euP;
                    eyVar4.a(1, dVar.uc, dVar.fEA, true);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    PbActivity pbActivity = this.evL;
                    aVar3 = this.evL.euO;
                    pbActivity.a(aVar3.getLoadDataMode(), (a.f) obj);
                    return;
                case 6:
                    a.f fVar = (a.f) obj;
                    eyVar2 = this.evL.euP;
                    aVar4 = this.evL.euO;
                    eyVar2.a(aVar4.getLoadDataMode(), fVar.uc, fVar.fEA, false);
                    eyVar3 = this.evL.euP;
                    eyVar3.ap(fVar.fEC);
                    return;
                default:
                    return;
            }
        }
        eyVar = this.evL.euP;
        aVar = this.evL.euO;
        eyVar.a(aVar.getLoadDataMode(), false, (String) null, false);
    }
}
