package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class i implements com.baidu.tbadk.core.view.ae {
    final /* synthetic */ PbActivity bIv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PbActivity pbActivity) {
        this.bIv = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.ae
    public void onListPullRefresh(boolean z) {
        bq bqVar;
        ci ciVar;
        bqVar = this.bIv.bHT;
        if (!bqVar.dN(true)) {
            ciVar = this.bIv.bHY;
            ciVar.aaO();
            return;
        }
        TiebaStatic.eventStat(this.bIv.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
    }
}
