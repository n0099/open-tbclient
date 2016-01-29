package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class m implements a.b {
    final /* synthetic */ PbActivity cNq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(PbActivity pbActivity) {
        this.cNq = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        cm cmVar;
        dz dzVar;
        dz dzVar2;
        dz dzVar3;
        cm cmVar2;
        dz dzVar4;
        this.cNq.Pj();
        cmVar = this.cNq.cMF;
        com.baidu.tbadk.core.data.u XU = cmVar.XU();
        dzVar = this.cNq.cMK;
        int pageNum = dzVar.getPageNum();
        if (pageNum <= 0) {
            this.cNq.showToast(t.j.pb_page_error);
        } else if (XU == null || pageNum <= XU.sq()) {
            dzVar2 = this.cNq.cMK;
            dzVar2.ajp();
            this.cNq.Oy();
            dzVar3 = this.cNq.cMK;
            dzVar3.arh();
            cmVar2 = this.cNq.cMF;
            dzVar4 = this.cNq.cMK;
            cmVar2.kQ(dzVar4.getPageNum());
            aVar.dismiss();
        } else {
            this.cNq.showToast(t.j.pb_page_error);
        }
    }
}
