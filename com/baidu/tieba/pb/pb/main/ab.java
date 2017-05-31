package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class ab implements a.b {
    final /* synthetic */ PbActivity enc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(PbActivity pbActivity) {
        this.enc = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        PbModel pbModel;
        fx fxVar;
        fx fxVar2;
        fx fxVar3;
        PbModel pbModel2;
        fx fxVar4;
        this.enc.aat();
        pbModel = this.enc.ele;
        com.baidu.tbadk.core.data.ar akK = pbModel.akK();
        fxVar = this.enc.elU;
        int pageNum = fxVar.getPageNum();
        if (pageNum <= 0) {
            this.enc.showToast(w.l.pb_page_error);
        } else if (akK == null || pageNum <= akK.qo()) {
            fxVar2 = this.enc.elU;
            fxVar2.avy();
            this.enc.os(2);
            this.enc.aas();
            fxVar3 = this.enc.elU;
            fxVar3.aMz();
            if (com.baidu.adp.lib.util.i.hk()) {
                pbModel2 = this.enc.ele;
                fxVar4 = this.enc.elU;
                pbModel2.oy(fxVar4.getPageNum());
            } else {
                this.enc.showToast(w.l.neterror);
            }
            aVar.dismiss();
        } else {
            this.enc.showToast(w.l.pb_page_error);
        }
    }
}
