package com.baidu.tieba.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class k implements com.baidu.adp.widget.ListView.ab {
    final /* synthetic */ PbActivity bAS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(PbActivity pbActivity) {
        this.bAS = pbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.ab
    public void onScrollToBottom() {
        bq bqVar;
        bz bzVar;
        bq bqVar2;
        bz bzVar2;
        bqVar = this.bAS.bAr;
        if (bqVar.dQ(false)) {
            bzVar2 = this.bAS.bAw;
            bzVar2.YB();
            TiebaStatic.eventStat(this.bAS.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
            return;
        }
        bzVar = this.bAS.bAw;
        bqVar2 = this.bAS.bAr;
        bzVar.h(bqVar2.getPbData());
    }
}
