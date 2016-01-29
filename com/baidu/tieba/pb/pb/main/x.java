package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class x implements BdListView.e {
    final /* synthetic */ PbActivity cNq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(PbActivity pbActivity) {
        this.cNq = pbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void nv() {
        boolean z;
        cm cmVar;
        dz dzVar;
        cm cmVar2;
        dz dzVar2;
        z = this.cNq.mIsLogin;
        if (z) {
            cmVar = this.cNq.cMF;
            if (cmVar.fr(false)) {
                dzVar2 = this.cNq.cMK;
                dzVar2.ari();
                TiebaStatic.eventStat(this.cNq.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                return;
            }
            dzVar = this.cNq.cMK;
            cmVar2 = this.cNq.cMF;
            dzVar.l(cmVar2.getPbData());
        }
    }
}
