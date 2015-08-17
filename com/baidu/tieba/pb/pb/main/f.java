package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class f implements a.b {
    final /* synthetic */ PbActivity cbo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PbActivity pbActivity) {
        this.cbo = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        bk bkVar;
        cb cbVar;
        cb cbVar2;
        cb cbVar3;
        bk bkVar2;
        cb cbVar4;
        this.cbo.Lt();
        bkVar = this.cbo.caL;
        com.baidu.tbadk.core.data.p adD = bkVar.adD();
        cbVar = this.cbo.caQ;
        int pageNum = cbVar.getPageNum();
        if (pageNum <= 0) {
            this.cbo.showToast(i.C0057i.pb_page_error);
        } else if (adD == null || pageNum <= adD.rP()) {
            cbVar2 = this.cbo.caQ;
            cbVar2.aeA();
            this.cbo.stopVoice();
            cbVar3 = this.cbo.caQ;
            cbVar3.ael();
            bkVar2 = this.cbo.caL;
            cbVar4 = this.cbo.caQ;
            bkVar2.ir(cbVar4.getPageNum());
            aVar.dismiss();
        } else {
            this.cbo.showToast(i.C0057i.pb_page_error);
        }
    }
}
