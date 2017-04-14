package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class x implements a.b {
    final /* synthetic */ PbActivity ejU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(PbActivity pbActivity) {
        this.ejU = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        PbModel pbModel;
        ey eyVar;
        ey eyVar2;
        ey eyVar3;
        PbModel pbModel2;
        ey eyVar4;
        this.ejU.Zq();
        pbModel = this.ejU.eif;
        com.baidu.tbadk.core.data.ap alU = pbModel.alU();
        eyVar = this.ejU.eiS;
        int pageNum = eyVar.getPageNum();
        if (pageNum <= 0) {
            this.ejU.showToast(w.l.pb_page_error);
        } else if (alU == null || pageNum <= alU.ri()) {
            eyVar2 = this.ejU.eiS;
            eyVar2.awH();
            this.ejU.od(2);
            this.ejU.Zp();
            eyVar3 = this.ejU.eiS;
            eyVar3.aNl();
            if (com.baidu.adp.lib.util.i.hj()) {
                pbModel2 = this.ejU.eif;
                eyVar4 = this.ejU.eiS;
                pbModel2.oh(eyVar4.getPageNum());
            } else {
                this.ejU.showToast(w.l.neterror);
            }
            aVar.dismiss();
        } else {
            this.ejU.showToast(w.l.pb_page_error);
        }
    }
}
