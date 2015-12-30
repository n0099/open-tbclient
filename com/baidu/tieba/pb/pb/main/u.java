package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class u implements BdListView.e {
    final /* synthetic */ PbActivity cFS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(PbActivity pbActivity) {
        this.cFS = pbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        boolean z;
        cf cfVar;
        dk dkVar;
        cf cfVar2;
        dk dkVar2;
        z = this.cFS.mIsLogin;
        if (z) {
            cfVar = this.cFS.cFl;
            if (cfVar.fc(false)) {
                dkVar2 = this.cFS.cFq;
                dkVar2.amL();
                TiebaStatic.eventStat(this.cFS.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                return;
            }
            dkVar = this.cFS.cFq;
            cfVar2 = this.cFS.cFl;
            dkVar.l(cfVar2.getPbData());
        }
    }
}
