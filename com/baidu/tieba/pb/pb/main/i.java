package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class i implements a.b {
    final /* synthetic */ PbActivity cjN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PbActivity pbActivity) {
        this.cjN = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        ca caVar;
        ct ctVar;
        ct ctVar2;
        ct ctVar3;
        ca caVar2;
        ct ctVar4;
        this.cjN.Ls();
        caVar = this.cjN.cjj;
        com.baidu.tbadk.core.data.o Rn = caVar.Rn();
        ctVar = this.cjN.cjo;
        int pageNum = ctVar.getPageNum();
        if (pageNum <= 0) {
            this.cjN.showToast(i.h.pb_page_error);
        } else if (Rn == null || pageNum <= Rn.rG()) {
            ctVar2 = this.cjN.cjo;
            ctVar2.aho();
            this.cjN.stopVoice();
            ctVar3 = this.cjN.cjo;
            ctVar3.agZ();
            caVar2 = this.cjN.cjj;
            ctVar4 = this.cjN.cjo;
            caVar2.jb(ctVar4.getPageNum());
            aVar.dismiss();
        } else {
            this.cjN.showToast(i.h.pb_page_error);
        }
    }
}
