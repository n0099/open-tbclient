package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class p implements BdListView.e {
    final /* synthetic */ PbActivity ciz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(PbActivity pbActivity) {
        this.ciz = pbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.e
    public void onScrollToBottom() {
        boolean z;
        bl blVar;
        cc ccVar;
        bl blVar2;
        cc ccVar2;
        z = this.ciz.mIsLogin;
        if (z) {
            blVar = this.ciz.chV;
            if (blVar.ex(false)) {
                ccVar2 = this.ciz.cia;
                ccVar2.agz();
                TiebaStatic.eventStat(this.ciz.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
                return;
            }
            ccVar = this.ciz.cia;
            blVar2 = this.ciz.chV;
            ccVar.k(blVar2.getPbData());
        }
    }
}
