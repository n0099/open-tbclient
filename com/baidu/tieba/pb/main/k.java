package com.baidu.tieba.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class k implements com.baidu.adp.widget.ListView.ab {
    final /* synthetic */ PbActivity bAT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PbActivity pbActivity) {
        this.bAT = pbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.ab
    public void onScrollToBottom() {
        bq bqVar;
        bz bzVar;
        bq bqVar2;
        bz bzVar2;
        bqVar = this.bAT.bAs;
        if (bqVar.dQ(false)) {
            bzVar2 = this.bAT.bAx;
            bzVar2.YG();
            TiebaStatic.eventStat(this.bAT.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
            return;
        }
        bzVar = this.bAT.bAx;
        bqVar2 = this.bAT.bAs;
        bzVar.h(bqVar2.getPbData());
    }
}
