package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class k implements a.b {
    final /* synthetic */ PbActivity cFS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PbActivity pbActivity) {
        this.cFS = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        cf cfVar;
        dk dkVar;
        dk dkVar2;
        dk dkVar3;
        cf cfVar2;
        dk dkVar4;
        this.cFS.Nm();
        cfVar = this.cFS.cFl;
        com.baidu.tbadk.core.data.q VB = cfVar.VB();
        dkVar = this.cFS.cFq;
        int pageNum = dkVar.getPageNum();
        if (pageNum <= 0) {
            this.cFS.showToast(n.j.pb_page_error);
        } else if (VB == null || pageNum <= VB.rK()) {
            dkVar2 = this.cFS.cFq;
            dkVar2.ana();
            this.cFS.stopVoice();
            dkVar3 = this.cFS.cFq;
            dkVar3.amJ();
            cfVar2 = this.cFS.cFl;
            dkVar4 = this.cFS.cFq;
            cfVar2.kq(dkVar4.getPageNum());
            aVar.dismiss();
        } else {
            this.cFS.showToast(n.j.pb_page_error);
        }
    }
}
