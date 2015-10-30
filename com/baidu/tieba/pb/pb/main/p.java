package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class p implements BdListView.e {
    final /* synthetic */ PbActivity ciK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PbActivity pbActivity) {
        this.ciK = pbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        boolean z;
        bl blVar;
        cc ccVar;
        bl blVar2;
        cc ccVar2;
        z = this.ciK.mIsLogin;
        if (z) {
            blVar = this.ciK.cih;
            if (blVar.ex(false)) {
                ccVar2 = this.ciK.cim;
                ccVar2.agv();
                TiebaStatic.eventStat(this.ciK.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                return;
            }
            ccVar = this.ciK.cim;
            blVar2 = this.ciK.cih;
            ccVar.k(blVar2.getPbData());
        }
    }
}
