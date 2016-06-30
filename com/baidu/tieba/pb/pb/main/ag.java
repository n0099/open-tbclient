package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.tbadkCore.f.a;
/* loaded from: classes.dex */
class ag extends com.baidu.adp.base.g {
    final /* synthetic */ PbActivity dPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(PbActivity pbActivity) {
        this.dPF = pbActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        es esVar;
        com.baidu.tieba.tbadkCore.f.a aVar;
        com.baidu.tieba.tbadkCore.f.a aVar2;
        com.baidu.tieba.tbadkCore.f.a aVar3;
        es esVar2;
        com.baidu.tieba.tbadkCore.f.a aVar4;
        es esVar3;
        es esVar4;
        dg dgVar;
        if (obj != null) {
            aVar2 = this.dPF.dON;
            switch (aVar2.getLoadDataMode()) {
                case 0:
                    dgVar = this.dPF.dOf;
                    dgVar.aFY();
                    this.dPF.a((a.b) obj);
                    return;
                case 1:
                    a.d dVar = (a.d) obj;
                    esVar4 = this.dPF.dOO;
                    esVar4.a(1, dVar.rg, dVar.eZR, true);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    PbActivity pbActivity = this.dPF;
                    aVar3 = this.dPF.dON;
                    pbActivity.a(aVar3.getLoadDataMode(), (a.f) obj);
                    return;
                case 6:
                    a.f fVar = (a.f) obj;
                    esVar2 = this.dPF.dOO;
                    aVar4 = this.dPF.dON;
                    esVar2.a(aVar4.getLoadDataMode(), fVar.rg, fVar.eZR, false);
                    esVar3 = this.dPF.dOO;
                    esVar3.ak(fVar.eZT);
                    return;
                default:
                    return;
            }
        }
        esVar = this.dPF.dOO;
        aVar = this.dPF.dON;
        esVar.a(aVar.getLoadDataMode(), false, (String) null, false);
    }
}
