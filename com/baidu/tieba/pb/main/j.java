package com.baidu.tieba.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class j implements com.baidu.adp.widget.ListView.g {
    final /* synthetic */ PbActivity bAS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PbActivity pbActivity) {
        this.bAS = pbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.g
    public void onListPullRefresh(boolean z) {
        bq bqVar;
        bz bzVar;
        bqVar = this.bAS.bAr;
        if (!bqVar.dR(true)) {
            bzVar = this.bAS.bAw;
            bzVar.YE();
            return;
        }
        TiebaStatic.eventStat(this.bAS.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
    }
}
