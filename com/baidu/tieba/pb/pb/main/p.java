package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class p implements BdListView.e {
    final /* synthetic */ PbActivity cbo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PbActivity pbActivity) {
        this.cbo = pbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        boolean z;
        bk bkVar;
        cb cbVar;
        bk bkVar2;
        cb cbVar2;
        z = this.cbo.mIsLogin;
        if (z) {
            bkVar = this.cbo.caL;
            if (bkVar.ek(false)) {
                cbVar2 = this.cbo.caQ;
                cbVar2.aen();
                TiebaStatic.eventStat(this.cbo.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                return;
            }
            cbVar = this.cbo.caQ;
            bkVar2 = this.cbo.caL;
            cbVar.k(bkVar2.getPbData());
        }
    }
}
