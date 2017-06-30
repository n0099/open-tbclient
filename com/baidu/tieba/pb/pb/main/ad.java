package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class ad implements a.b {
    final /* synthetic */ PbActivity ewh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(PbActivity pbActivity) {
        this.ewh = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        PbModel pbModel;
        gg ggVar;
        gg ggVar2;
        gg ggVar3;
        PbModel pbModel2;
        gg ggVar4;
        this.ewh.aej();
        pbModel = this.ewh.eue;
        com.baidu.tbadk.core.data.as aov = pbModel.aov();
        ggVar = this.ewh.euU;
        int pageNum = ggVar.getPageNum();
        if (pageNum <= 0) {
            this.ewh.showToast(w.l.pb_page_error);
        } else if (aov == null || pageNum <= aov.ql()) {
            ggVar2 = this.ewh.euU;
            ggVar2.azw();
            this.ewh.oI(2);
            this.ewh.aei();
            ggVar3 = this.ewh.euU;
            ggVar3.aQx();
            if (com.baidu.adp.lib.util.i.hj()) {
                pbModel2 = this.ewh.eue;
                ggVar4 = this.ewh.euU;
                pbModel2.oP(ggVar4.getPageNum());
            } else {
                this.ewh.showToast(w.l.neterror);
            }
            aVar.dismiss();
        } else {
            this.ewh.showToast(w.l.pb_page_error);
        }
    }
}
