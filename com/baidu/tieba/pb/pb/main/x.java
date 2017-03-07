package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class x implements a.b {
    final /* synthetic */ PbActivity elO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(PbActivity pbActivity) {
        this.elO = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        PbModel pbModel;
        fa faVar;
        fa faVar2;
        fa faVar3;
        PbModel pbModel2;
        fa faVar4;
        this.elO.YU();
        pbModel = this.elO.ejZ;
        com.baidu.tbadk.core.data.aq ama = pbModel.ama();
        faVar = this.elO.ekM;
        int pageNum = faVar.getPageNum();
        if (pageNum <= 0) {
            this.elO.showToast(w.l.pb_page_error);
        } else if (ama == null || pageNum <= ama.qL()) {
            faVar2 = this.elO.ekM;
            faVar2.awO();
            this.elO.of(2);
            this.elO.YT();
            faVar3 = this.elO.ekM;
            faVar3.aNc();
            if (com.baidu.adp.lib.util.i.he()) {
                pbModel2 = this.elO.ejZ;
                faVar4 = this.elO.ekM;
                pbModel2.oj(faVar4.getPageNum());
            } else {
                this.elO.showToast(w.l.neterror);
            }
            aVar.dismiss();
        } else {
            this.elO.showToast(w.l.pb_page_error);
        }
    }
}
