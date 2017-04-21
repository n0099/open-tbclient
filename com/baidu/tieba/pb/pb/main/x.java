package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class x implements a.b {
    final /* synthetic */ PbActivity emk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(PbActivity pbActivity) {
        this.emk = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        PbModel pbModel;
        ey eyVar;
        ey eyVar2;
        ey eyVar3;
        PbModel pbModel2;
        ey eyVar4;
        this.emk.aar();
        pbModel = this.emk.ekv;
        com.baidu.tbadk.core.data.ap amV = pbModel.amV();
        eyVar = this.emk.eli;
        int pageNum = eyVar.getPageNum();
        if (pageNum <= 0) {
            this.emk.showToast(w.l.pb_page_error);
        } else if (amV == null || pageNum <= amV.ri()) {
            eyVar2 = this.emk.eli;
            eyVar2.axI();
            this.emk.oj(2);
            this.emk.aaq();
            eyVar3 = this.emk.eli;
            eyVar3.aOm();
            if (com.baidu.adp.lib.util.i.hk()) {
                pbModel2 = this.emk.ekv;
                eyVar4 = this.emk.eli;
                pbModel2.on(eyVar4.getPageNum());
            } else {
                this.emk.showToast(w.l.neterror);
            }
            aVar.dismiss();
        } else {
            this.emk.showToast(w.l.pb_page_error);
        }
    }
}
