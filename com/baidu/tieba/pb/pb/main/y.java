package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class y implements a.b {
    final /* synthetic */ PbActivity eob;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(PbActivity pbActivity) {
        this.eob = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        dh dhVar;
        ex exVar;
        ex exVar2;
        ex exVar3;
        dh dhVar2;
        ex exVar4;
        this.eob.aaQ();
        dhVar = this.eob.emx;
        com.baidu.tbadk.core.data.ak aoU = dhVar.aoU();
        exVar = this.eob.enh;
        int pageNum = exVar.getPageNum();
        if (pageNum <= 0) {
            this.eob.showToast(t.j.pb_page_error);
        } else if (aoU == null || pageNum <= aoU.ql()) {
            exVar2 = this.eob.enh;
            exVar2.aAE();
            this.eob.od(2);
            this.eob.aaO();
            exVar3 = this.eob.enh;
            exVar3.aPp();
            if (com.baidu.adp.lib.util.i.gm()) {
                dhVar2 = this.eob.emx;
                exVar4 = this.eob.enh;
                dhVar2.oi(exVar4.getPageNum());
            } else {
                this.eob.showToast(t.j.neterror);
            }
            aVar.dismiss();
        } else {
            this.eob.showToast(t.j.pb_page_error);
        }
    }
}
