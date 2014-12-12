package com.baidu.tieba.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class j implements com.baidu.adp.widget.ListView.ab {
    final /* synthetic */ PbActivity bzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PbActivity pbActivity) {
        this.bzj = pbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.ab
    public void onScrollToBottom() {
        bq bqVar;
        bz bzVar;
        bq bqVar2;
        bz bzVar2;
        bqVar = this.bzj.byJ;
        if (bqVar.dK(false)) {
            bzVar2 = this.bzj.byO;
            bzVar2.Yb();
            TiebaStatic.eventStat(this.bzj.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
            return;
        }
        bzVar = this.bzj.byO;
        bqVar2 = this.bzj.byJ;
        bzVar.h(bqVar2.getPbData());
    }
}
