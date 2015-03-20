package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class j implements com.baidu.adp.widget.ListView.x {
    final /* synthetic */ PbActivity bIv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PbActivity pbActivity) {
        this.bIv = pbActivity;
    }

    @Override // com.baidu.adp.widget.ListView.x
    public void onScrollToBottom() {
        bq bqVar;
        ci ciVar;
        bq bqVar2;
        ci ciVar2;
        bqVar = this.bIv.bHT;
        if (bqVar.dM(false)) {
            ciVar2 = this.bIv.bHY;
            ciVar2.aaL();
            TiebaStatic.eventStat(this.bIv.getPageContext().getPageActivity(), "pb_more", "pbclick", 1, new Object[0]);
            return;
        }
        ciVar = this.bIv.bHY;
        bqVar2 = this.bIv.bHT;
        ciVar.h(bqVar2.getPbData());
    }
}
