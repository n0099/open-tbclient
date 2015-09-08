package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class f implements a.b {
    final /* synthetic */ PbActivity ccj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PbActivity pbActivity) {
        this.ccj = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        bk bkVar;
        cb cbVar;
        cb cbVar2;
        cb cbVar3;
        bk bkVar2;
        cb cbVar4;
        this.ccj.Lk();
        bkVar = this.ccj.cbG;
        com.baidu.tbadk.core.data.o adR = bkVar.adR();
        cbVar = this.ccj.cbL;
        int pageNum = cbVar.getPageNum();
        if (pageNum <= 0) {
            this.ccj.showToast(i.h.pb_page_error);
        } else if (adR == null || pageNum <= adR.rM()) {
            cbVar2 = this.ccj.cbL;
            cbVar2.aeO();
            this.ccj.stopVoice();
            cbVar3 = this.ccj.cbL;
            cbVar3.aez();
            bkVar2 = this.ccj.cbG;
            cbVar4 = this.ccj.cbL;
            bkVar2.iC(cbVar4.getPageNum());
            aVar.dismiss();
        } else {
            this.ccj.showToast(i.h.pb_page_error);
        }
    }
}
