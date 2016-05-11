package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.tbadkCore.f.a;
/* loaded from: classes.dex */
class ac extends com.baidu.adp.base.g {
    final /* synthetic */ PbActivity djE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(PbActivity pbActivity) {
        this.djE = pbActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        el elVar;
        com.baidu.tieba.tbadkCore.f.a aVar;
        com.baidu.tieba.tbadkCore.f.a aVar2;
        com.baidu.tieba.tbadkCore.f.a aVar3;
        el elVar2;
        com.baidu.tieba.tbadkCore.f.a aVar4;
        el elVar3;
        el elVar4;
        cw cwVar;
        if (obj != null) {
            aVar2 = this.djE.diO;
            switch (aVar2.getLoadDataMode()) {
                case 0:
                    cwVar = this.djE.dih;
                    cwVar.axN();
                    this.djE.a((a.b) obj);
                    return;
                case 1:
                    a.d dVar = (a.d) obj;
                    elVar4 = this.djE.diR;
                    elVar4.a(1, dVar.rg, dVar.evb, true);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    PbActivity pbActivity = this.djE;
                    aVar3 = this.djE.diO;
                    pbActivity.a(aVar3.getLoadDataMode(), (a.f) obj);
                    return;
                case 6:
                    a.f fVar = (a.f) obj;
                    elVar2 = this.djE.diR;
                    aVar4 = this.djE.diO;
                    elVar2.a(aVar4.getLoadDataMode(), fVar.rg, fVar.evb, false);
                    elVar3 = this.djE.diR;
                    elVar3.aa(fVar.evd);
                    return;
                default:
                    return;
            }
        }
        elVar = this.djE.diR;
        aVar = this.djE.diO;
        elVar.a(aVar.getLoadDataMode(), false, (String) null, false);
    }
}
