package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.tbadkCore.h.a;
/* loaded from: classes.dex */
class l extends com.baidu.adp.base.g {
    final /* synthetic */ PbActivity cbo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PbActivity pbActivity) {
        this.cbo = pbActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        cb cbVar;
        com.baidu.tieba.tbadkCore.h.a aVar;
        com.baidu.tieba.tbadkCore.h.a aVar2;
        com.baidu.tieba.tbadkCore.h.a aVar3;
        bk bkVar;
        if (obj != null) {
            aVar2 = this.cbo.caN;
            switch (aVar2.getLoadDataMode()) {
                case 0:
                    bkVar = this.cbo.caL;
                    bkVar.adK();
                    this.cbo.a((a.b) obj);
                    return;
                case 1:
                    this.cbo.a((a.d) obj);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    PbActivity pbActivity = this.cbo;
                    aVar3 = this.cbo.caN;
                    pbActivity.a(aVar3.getLoadDataMode(), (a.f) obj);
                    return;
                case 6:
                    this.cbo.a((a.f) obj);
                    return;
                default:
                    return;
            }
        }
        cbVar = this.cbo.caQ;
        aVar = this.cbo.caN;
        cbVar.a(aVar.getLoadDataMode(), false, (String) null, false);
    }
}
