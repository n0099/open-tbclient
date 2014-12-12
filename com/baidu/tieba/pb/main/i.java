package com.baidu.tieba.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class i implements com.baidu.adp.widget.ListView.g {
    final /* synthetic */ PbActivity bzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PbActivity pbActivity) {
        this.bzj = pbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.g
    public void onListPullRefresh(boolean z) {
        bq bqVar;
        bz bzVar;
        bqVar = this.bzj.byJ;
        if (!bqVar.dL(true)) {
            bzVar = this.bzj.byO;
            bzVar.Ye();
            return;
        }
        TiebaStatic.eventStat(this.bzj.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
    }
}
