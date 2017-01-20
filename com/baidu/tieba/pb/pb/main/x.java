package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class x implements a.b {
    final /* synthetic */ PbActivity eiV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(PbActivity pbActivity) {
        this.eiV = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        PbModel pbModel;
        ez ezVar;
        ez ezVar2;
        ez ezVar3;
        PbModel pbModel2;
        ez ezVar4;
        this.eiV.XV();
        pbModel = this.eiV.ehh;
        com.baidu.tbadk.core.data.ao amN = pbModel.amN();
        ezVar = this.eiV.ehV;
        int pageNum = ezVar.getPageNum();
        if (pageNum <= 0) {
            this.eiV.showToast(r.l.pb_page_error);
        } else if (amN == null || pageNum <= amN.qs()) {
            ezVar2 = this.eiV.ehV;
            ezVar2.axs();
            this.eiV.or(2);
            this.eiV.XU();
            ezVar3 = this.eiV.ehV;
            ezVar3.aNJ();
            if (com.baidu.adp.lib.util.i.gk()) {
                pbModel2 = this.eiV.ehh;
                ezVar4 = this.eiV.ehV;
                pbModel2.ov(ezVar4.getPageNum());
            } else {
                this.eiV.showToast(r.l.neterror);
            }
            aVar.dismiss();
        } else {
            this.eiV.showToast(r.l.pb_page_error);
        }
    }
}
