package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
class j implements a.b {
    final /* synthetic */ PbActivity cCm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PbActivity pbActivity) {
        this.cCm = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        cc ccVar;
        da daVar;
        da daVar2;
        da daVar3;
        cc ccVar2;
        da daVar4;
        this.cCm.MS();
        ccVar = this.cCm.cBG;
        com.baidu.tbadk.core.data.q Uy = ccVar.Uy();
        daVar = this.cCm.cBL;
        int pageNum = daVar.getPageNum();
        if (pageNum <= 0) {
            this.cCm.showToast(n.i.pb_page_error);
        } else if (Uy == null || pageNum <= Uy.sb()) {
            daVar2 = this.cCm.cBL;
            daVar2.alO();
            this.cCm.stopVoice();
            daVar3 = this.cCm.cBL;
            daVar3.alx();
            ccVar2 = this.cCm.cBG;
            daVar4 = this.cCm.cBL;
            ccVar2.jT(daVar4.getPageNum());
            aVar.dismiss();
        } else {
            this.cCm.showToast(n.i.pb_page_error);
        }
    }
}
