package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class x implements a.b {
    final /* synthetic */ PbActivity eah;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(PbActivity pbActivity) {
        this.eah = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        dc dcVar;
        er erVar;
        er erVar2;
        er erVar3;
        dc dcVar2;
        er erVar4;
        this.eah.WE();
        dcVar = this.eah.dYA;
        com.baidu.tbadk.core.data.an alG = dcVar.alG();
        erVar = this.eah.dZk;
        int pageNum = erVar.getPageNum();
        if (pageNum <= 0) {
            this.eah.showToast(r.j.pb_page_error);
        } else if (alG == null || pageNum <= alG.qz()) {
            erVar2 = this.eah.dZk;
            erVar2.awl();
            this.eah.nz(2);
            this.eah.WD();
            erVar3 = this.eah.dZk;
            erVar3.aLU();
            if (com.baidu.adp.lib.util.i.gm()) {
                dcVar2 = this.eah.dYA;
                erVar4 = this.eah.dZk;
                dcVar2.nE(erVar4.getPageNum());
            } else {
                this.eah.showToast(r.j.neterror);
            }
            aVar.dismiss();
        } else {
            this.eah.showToast(r.j.pb_page_error);
        }
    }
}
