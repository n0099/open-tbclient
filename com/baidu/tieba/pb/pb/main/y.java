package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class y implements a.b {
    final /* synthetic */ PbActivity ehy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(PbActivity pbActivity) {
        this.ehy = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        PbModel pbModel;
        fm fmVar;
        fm fmVar2;
        fm fmVar3;
        PbModel pbModel2;
        fm fmVar4;
        this.ehy.Zp();
        pbModel = this.ehy.efE;
        com.baidu.tbadk.core.data.aq ajK = pbModel.ajK();
        fmVar = this.ehy.egt;
        int pageNum = fmVar.getPageNum();
        if (pageNum <= 0) {
            this.ehy.showToast(w.l.pb_page_error);
        } else if (ajK == null || pageNum <= ajK.qs()) {
            fmVar2 = this.ehy.egt;
            fmVar2.auE();
            this.ehy.nZ(2);
            this.ehy.Zo();
            fmVar3 = this.ehy.egt;
            fmVar3.aLD();
            if (com.baidu.adp.lib.util.i.hk()) {
                pbModel2 = this.ehy.efE;
                fmVar4 = this.ehy.egt;
                pbModel2.of(fmVar4.getPageNum());
            } else {
                this.ehy.showToast(w.l.neterror);
            }
            aVar.dismiss();
        } else {
            this.ehy.showToast(w.l.pb_page_error);
        }
    }
}
