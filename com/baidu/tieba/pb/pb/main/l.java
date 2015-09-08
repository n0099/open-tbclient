package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.tbadkCore.h.a;
/* loaded from: classes.dex */
class l extends com.baidu.adp.base.g {
    final /* synthetic */ PbActivity ccj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PbActivity pbActivity) {
        this.ccj = pbActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        cb cbVar;
        com.baidu.tieba.tbadkCore.h.a aVar;
        com.baidu.tieba.tbadkCore.h.a aVar2;
        com.baidu.tieba.tbadkCore.h.a aVar3;
        bk bkVar;
        if (obj != null) {
            aVar2 = this.ccj.cbI;
            switch (aVar2.getLoadDataMode()) {
                case 0:
                    bkVar = this.ccj.cbG;
                    bkVar.adY();
                    this.ccj.a((a.b) obj);
                    return;
                case 1:
                    this.ccj.a((a.d) obj);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    PbActivity pbActivity = this.ccj;
                    aVar3 = this.ccj.cbI;
                    pbActivity.a(aVar3.getLoadDataMode(), (a.f) obj);
                    return;
                case 6:
                    this.ccj.a((a.f) obj);
                    return;
                default:
                    return;
            }
        }
        cbVar = this.ccj.cbL;
        aVar = this.ccj.cbI;
        cbVar.a(aVar.getLoadDataMode(), false, (String) null, false);
    }
}
