package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class i implements com.baidu.tbadk.core.view.aj {
    final /* synthetic */ PbActivity bKT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(PbActivity pbActivity) {
        this.bKT = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.aj
    public void onListPullRefresh(boolean z) {
        bo boVar;
        ch chVar;
        boVar = this.bKT.bKv;
        if (!boVar.dW(true)) {
            chVar = this.bKT.bKz;
            chVar.acj();
            return;
        }
        TiebaStatic.eventStat(this.bKT.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
    }
}
