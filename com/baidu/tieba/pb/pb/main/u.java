package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.tbadkCore.f.a;
/* loaded from: classes.dex */
class u extends com.baidu.adp.base.g {
    final /* synthetic */ PbActivity cNq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(PbActivity pbActivity) {
        this.cNq = pbActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        dz dzVar;
        com.baidu.tieba.tbadkCore.f.a aVar;
        com.baidu.tieba.tbadkCore.f.a aVar2;
        com.baidu.tieba.tbadkCore.f.a aVar3;
        cm cmVar;
        if (obj != null) {
            aVar2 = this.cNq.cMH;
            switch (aVar2.getLoadDataMode()) {
                case 0:
                    cmVar = this.cNq.cMF;
                    cmVar.aqb();
                    this.cNq.a((a.b) obj);
                    return;
                case 1:
                    this.cNq.a((a.d) obj);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    PbActivity pbActivity = this.cNq;
                    aVar3 = this.cNq.cMH;
                    pbActivity.a(aVar3.getLoadDataMode(), (a.f) obj);
                    return;
                case 6:
                    this.cNq.a((a.f) obj);
                    return;
                default:
                    return;
            }
        }
        dzVar = this.cNq.cMK;
        aVar = this.cNq.cMH;
        dzVar.a(aVar.getLoadDataMode(), false, (String) null, false);
    }
}
