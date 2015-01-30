package com.baidu.tieba.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class j implements com.baidu.adp.widget.ListView.g {
    final /* synthetic */ PbActivity bAT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PbActivity pbActivity) {
        this.bAT = pbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.g
    public void onListPullRefresh(boolean z) {
        bq bqVar;
        bz bzVar;
        bqVar = this.bAT.bAs;
        if (!bqVar.dR(true)) {
            bzVar = this.bAT.bAx;
            bzVar.YJ();
            return;
        }
        TiebaStatic.eventStat(this.bAT.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
    }
}
