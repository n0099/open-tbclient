package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class f implements a.b {
    final /* synthetic */ PbActivity ciK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PbActivity pbActivity) {
        this.ciK = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        bl blVar;
        cc ccVar;
        cc ccVar2;
        cc ccVar3;
        bl blVar2;
        cc ccVar4;
        this.ciK.Lc();
        blVar = this.ciK.cih;
        com.baidu.tbadk.core.data.o QR = blVar.QR();
        ccVar = this.ciK.cim;
        int pageNum = ccVar.getPageNum();
        if (pageNum <= 0) {
            this.ciK.showToast(i.h.pb_page_error);
        } else if (QR == null || pageNum <= QR.rE()) {
            ccVar2 = this.ciK.cim;
            ccVar2.agI();
            this.ciK.stopVoice();
            ccVar3 = this.ciK.cim;
            ccVar3.agt();
            blVar2 = this.ciK.cih;
            ccVar4 = this.ciK.cim;
            blVar2.iM(ccVar4.getPageNum());
            aVar.dismiss();
        } else {
            this.ciK.showToast(i.h.pb_page_error);
        }
    }
}
