package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class p implements BdListView.e {
    final /* synthetic */ PbActivity ccj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PbActivity pbActivity) {
        this.ccj = pbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        boolean z;
        bk bkVar;
        cb cbVar;
        bk bkVar2;
        cb cbVar2;
        z = this.ccj.mIsLogin;
        if (z) {
            bkVar = this.ccj.cbG;
            if (bkVar.es(false)) {
                cbVar2 = this.ccj.cbL;
                cbVar2.aeB();
                TiebaStatic.eventStat(this.ccj.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                return;
            }
            cbVar = this.ccj.cbL;
            bkVar2 = this.ccj.cbG;
            cbVar.k(bkVar2.getPbData());
        }
    }
}
