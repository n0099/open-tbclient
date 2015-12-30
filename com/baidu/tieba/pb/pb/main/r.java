package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.tbadkCore.f.a;
/* loaded from: classes.dex */
class r extends com.baidu.adp.base.g {
    final /* synthetic */ PbActivity cFS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(PbActivity pbActivity) {
        this.cFS = pbActivity;
    }

    @Override // com.baidu.adp.base.g
    public void d(Object obj) {
        dk dkVar;
        com.baidu.tieba.tbadkCore.f.a aVar;
        com.baidu.tieba.tbadkCore.f.a aVar2;
        com.baidu.tieba.tbadkCore.f.a aVar3;
        cf cfVar;
        if (obj != null) {
            aVar2 = this.cFS.cFn;
            switch (aVar2.getLoadDataMode()) {
                case 0:
                    cfVar = this.cFS.cFl;
                    cfVar.alY();
                    this.cFS.a((a.b) obj);
                    return;
                case 1:
                    this.cFS.a((a.d) obj);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    PbActivity pbActivity = this.cFS;
                    aVar3 = this.cFS.cFn;
                    pbActivity.a(aVar3.getLoadDataMode(), (a.f) obj);
                    return;
                case 6:
                    this.cFS.a((a.f) obj);
                    return;
                default:
                    return;
            }
        }
        dkVar = this.cFS.cFq;
        aVar = this.cFS.cFn;
        dkVar.a(aVar.getLoadDataMode(), false, (String) null, false);
    }
}
