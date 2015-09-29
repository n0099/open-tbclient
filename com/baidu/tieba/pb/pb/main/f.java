package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class f implements a.b {
    final /* synthetic */ PbActivity ciz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PbActivity pbActivity) {
        this.ciz = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        bl blVar;
        cc ccVar;
        cc ccVar2;
        cc ccVar3;
        bl blVar2;
        cc ccVar4;
        this.ciz.Lg();
        blVar = this.ciz.chV;
        com.baidu.tbadk.core.data.n QV = blVar.QV();
        ccVar = this.ciz.cia;
        int pageNum = ccVar.getPageNum();
        if (pageNum <= 0) {
            this.ciz.showToast(i.h.pb_page_error);
        } else if (QV == null || pageNum <= QV.rH()) {
            ccVar2 = this.ciz.cia;
            ccVar2.agM();
            this.ciz.stopVoice();
            ccVar3 = this.ciz.cia;
            ccVar3.agx();
            blVar2 = this.ciz.chV;
            ccVar4 = this.ciz.cia;
            blVar2.iM(ccVar4.getPageNum());
            aVar.dismiss();
        } else {
            this.ciz.showToast(i.h.pb_page_error);
        }
    }
}
