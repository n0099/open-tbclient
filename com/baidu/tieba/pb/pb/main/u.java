package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class u implements a.b {
    final /* synthetic */ PbActivity djE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(PbActivity pbActivity) {
        this.djE = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        cw cwVar;
        el elVar;
        el elVar2;
        el elVar3;
        cw cwVar2;
        el elVar4;
        this.djE.PY();
        cwVar = this.djE.dih;
        com.baidu.tbadk.core.data.ad abu = cwVar.abu();
        elVar = this.djE.diR;
        int pageNum = elVar.getPageNum();
        if (pageNum <= 0) {
            this.djE.showToast(t.j.pb_page_error);
        } else if (abu == null || pageNum <= abu.pF()) {
            elVar2 = this.djE.diR;
            elVar2.amT();
            this.djE.Pm();
            elVar3 = this.djE.diR;
            elVar3.azd();
            cwVar2 = this.djE.dih;
            elVar4 = this.djE.diR;
            cwVar2.lN(elVar4.getPageNum());
            aVar.dismiss();
        } else {
            this.djE.showToast(t.j.pb_page_error);
        }
    }
}
