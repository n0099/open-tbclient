package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.tbadkCore.f.a;
/* loaded from: classes.dex */
class ag extends com.baidu.adp.base.g {
    final /* synthetic */ PbActivity ebT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(PbActivity pbActivity) {
        this.ebT = pbActivity;
    }

    @Override // com.baidu.adp.base.g
    public void g(Object obj) {
        ew ewVar;
        com.baidu.tieba.tbadkCore.f.a aVar;
        com.baidu.tieba.tbadkCore.f.a aVar2;
        com.baidu.tieba.tbadkCore.f.a aVar3;
        ew ewVar2;
        com.baidu.tieba.tbadkCore.f.a aVar4;
        ew ewVar3;
        ew ewVar4;
        dh dhVar;
        if (obj != null) {
            aVar2 = this.ebT.eba;
            switch (aVar2.getLoadDataMode()) {
                case 0:
                    dhVar = this.ebT.eas;
                    dhVar.aJj();
                    this.ebT.a((a.b) obj);
                    return;
                case 1:
                    a.d dVar = (a.d) obj;
                    ewVar4 = this.ebT.ebb;
                    ewVar4.a(1, dVar.rJ, dVar.fmU, true);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    PbActivity pbActivity = this.ebT;
                    aVar3 = this.ebT.eba;
                    pbActivity.a(aVar3.getLoadDataMode(), (a.f) obj);
                    return;
                case 6:
                    a.f fVar = (a.f) obj;
                    ewVar2 = this.ebT.ebb;
                    aVar4 = this.ebT.eba;
                    ewVar2.a(aVar4.getLoadDataMode(), fVar.rJ, fVar.fmU, false);
                    ewVar3 = this.ebT.ebb;
                    ewVar3.an(fVar.fmW);
                    return;
                default:
                    return;
            }
        }
        ewVar = this.ebT.ebb;
        aVar = this.ebT.eba;
        ewVar.a(aVar.getLoadDataMode(), false, (String) null, false);
    }
}
