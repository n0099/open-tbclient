package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class y implements a.b {
    final /* synthetic */ PbActivity evL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(PbActivity pbActivity) {
        this.evL = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        dj djVar;
        ey eyVar;
        ey eyVar2;
        ey eyVar3;
        dj djVar2;
        ey eyVar4;
        this.evL.acq();
        djVar = this.evL.euf;
        com.baidu.tbadk.core.data.ao are = djVar.are();
        eyVar = this.evL.euP;
        int pageNum = eyVar.getPageNum();
        if (pageNum <= 0) {
            this.evL.showToast(r.j.pb_page_error);
        } else if (are == null || pageNum <= are.qy()) {
            eyVar2 = this.evL.euP;
            eyVar2.aCY();
            this.evL.ox(2);
            this.evL.acp();
            eyVar3 = this.evL.euP;
            eyVar3.aSa();
            if (com.baidu.adp.lib.util.i.gm()) {
                djVar2 = this.evL.euf;
                eyVar4 = this.evL.euP;
                djVar2.oC(eyVar4.getPageNum());
            } else {
                this.evL.showToast(r.j.neterror);
            }
            aVar.dismiss();
        } else {
            this.evL.showToast(r.j.pb_page_error);
        }
    }
}
