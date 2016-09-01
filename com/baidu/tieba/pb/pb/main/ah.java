package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.tbadkCore.f.a;
/* loaded from: classes.dex */
class ah extends com.baidu.adp.base.g {
    final /* synthetic */ PbActivity eob;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(PbActivity pbActivity) {
        this.eob = pbActivity;
    }

    @Override // com.baidu.adp.base.g
    public void g(Object obj) {
        ex exVar;
        com.baidu.tieba.tbadkCore.f.a aVar;
        com.baidu.tieba.tbadkCore.f.a aVar2;
        com.baidu.tieba.tbadkCore.f.a aVar3;
        ex exVar2;
        com.baidu.tieba.tbadkCore.f.a aVar4;
        ex exVar3;
        ex exVar4;
        dh dhVar;
        boolean z = false;
        if (obj != null) {
            aVar2 = this.eob.eng;
            switch (aVar2.getLoadDataMode()) {
                case 0:
                    dhVar = this.eob.emx;
                    dhVar.aOa();
                    a.b bVar = (a.b) obj;
                    if (bVar.cuz || bVar.ewn <= 0 || bVar.fuM == 0) {
                        z = true;
                    } else {
                        com.baidu.tieba.c.a.a(this.eob.getPageContext(), 2, 1);
                    }
                    this.eob.a(bVar, z);
                    return;
                case 1:
                    a.d dVar = (a.d) obj;
                    exVar4 = this.eob.enh;
                    exVar4.a(1, dVar.ub, dVar.fuO, true);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    PbActivity pbActivity = this.eob;
                    aVar3 = this.eob.eng;
                    pbActivity.a(aVar3.getLoadDataMode(), (a.f) obj);
                    return;
                case 6:
                    a.f fVar = (a.f) obj;
                    exVar2 = this.eob.enh;
                    aVar4 = this.eob.eng;
                    exVar2.a(aVar4.getLoadDataMode(), fVar.ub, fVar.fuO, false);
                    exVar3 = this.eob.enh;
                    exVar3.am(fVar.fuQ);
                    return;
                default:
                    return;
            }
        }
        exVar = this.eob.enh;
        aVar = this.eob.eng;
        exVar.a(aVar.getLoadDataMode(), false, (String) null, false);
    }
}
