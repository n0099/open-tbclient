package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class x implements a.b {
    final /* synthetic */ PbActivity ebT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(PbActivity pbActivity) {
        this.ebT = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        dh dhVar;
        ew ewVar;
        ew ewVar2;
        ew ewVar3;
        dh dhVar2;
        ew ewVar4;
        this.ebT.VT();
        dhVar = this.ebT.eas;
        com.baidu.tbadk.core.data.aj akg = dhVar.akg();
        ewVar = this.ebT.ebb;
        int pageNum = ewVar.getPageNum();
        if (pageNum <= 0) {
            this.ebT.showToast(u.j.pb_page_error);
        } else if (akg == null || pageNum <= akg.pi()) {
            ewVar2 = this.ebT.ebb;
            ewVar2.avR();
            this.ebT.nA(2);
            this.ebT.VR();
            ewVar3 = this.ebT.ebb;
            ewVar3.aKy();
            if (com.baidu.adp.lib.util.i.fq()) {
                dhVar2 = this.ebT.eas;
                ewVar4 = this.ebT.ebb;
                dhVar2.nE(ewVar4.getPageNum());
            } else {
                this.ebT.showToast(u.j.neterror);
            }
            aVar.dismiss();
        } else {
            this.ebT.showToast(u.j.pb_page_error);
        }
    }
}
