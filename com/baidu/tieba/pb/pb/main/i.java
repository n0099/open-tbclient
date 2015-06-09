package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class i implements com.baidu.tbadk.core.view.aj {
    final /* synthetic */ PbActivity bKU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PbActivity pbActivity) {
        this.bKU = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.aj
    public void onListPullRefresh(boolean z) {
        bo boVar;
        ch chVar;
        boVar = this.bKU.bKw;
        if (!boVar.dW(true)) {
            chVar = this.bKU.bKA;
            chVar.ack();
            return;
        }
        TiebaStatic.eventStat(this.bKU.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
    }
}
