package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.dialog.a;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class x implements a.b {
    final /* synthetic */ PbActivity dPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(PbActivity pbActivity) {
        this.dPF = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void a(com.baidu.tbadk.core.dialog.a aVar) {
        dg dgVar;
        es esVar;
        es esVar2;
        es esVar3;
        dg dgVar2;
        es esVar4;
        this.dPF.VB();
        dgVar = this.dPF.dOf;
        com.baidu.tbadk.core.data.af ajw = dgVar.ajw();
        esVar = this.dPF.dOO;
        int pageNum = esVar.getPageNum();
        if (pageNum <= 0) {
            this.dPF.showToast(u.j.pb_page_error);
        } else if (ajw == null || pageNum <= ajw.pz()) {
            esVar2 = this.dPF.dOO;
            esVar2.avf();
            this.dPF.ni(2);
            this.dPF.UR();
            esVar3 = this.dPF.dOO;
            esVar3.aHn();
            dgVar2 = this.dPF.dOf;
            esVar4 = this.dPF.dOO;
            dgVar2.nm(esVar4.getPageNum());
            aVar.dismiss();
        } else {
            this.dPF.showToast(u.j.pb_page_error);
        }
    }
}
