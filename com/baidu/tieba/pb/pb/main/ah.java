package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.tbadkCore.f.a;
/* loaded from: classes.dex */
class ah extends com.baidu.adp.base.g {
    final /* synthetic */ PbActivity eqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ah(PbActivity pbActivity) {
        this.eqa = pbActivity;
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
            aVar2 = this.eqa.epd;
            switch (aVar2.getLoadDataMode()) {
                case 0:
                    dhVar = this.eqa.eov;
                    dhVar.aOI();
                    a.b bVar = (a.b) obj;
                    if (bVar.cuW || bVar.eyv <= 0 || bVar.fxt == 0) {
                        z = true;
                    } else {
                        com.baidu.tieba.c.a.a(this.eqa.getPageContext(), 2, 1);
                    }
                    this.eqa.a(bVar, z);
                    return;
                case 1:
                    a.d dVar = (a.d) obj;
                    exVar4 = this.eqa.epe;
                    exVar4.a(1, dVar.ub, dVar.fxv, true);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    PbActivity pbActivity = this.eqa;
                    aVar3 = this.eqa.epd;
                    pbActivity.a(aVar3.getLoadDataMode(), (a.f) obj);
                    return;
                case 6:
                    a.f fVar = (a.f) obj;
                    exVar2 = this.eqa.epe;
                    aVar4 = this.eqa.epd;
                    exVar2.a(aVar4.getLoadDataMode(), fVar.ub, fVar.fxv, false);
                    exVar3 = this.eqa.epe;
                    exVar3.am(fVar.fxx);
                    return;
                default:
                    return;
            }
        }
        exVar = this.eqa.epe;
        aVar = this.eqa.epd;
        exVar.a(aVar.getLoadDataMode(), false, (String) null, false);
    }
}
