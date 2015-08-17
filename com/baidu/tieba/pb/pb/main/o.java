package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.x;
/* loaded from: classes.dex */
class o implements x.a {
    final /* synthetic */ PbActivity cbo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(PbActivity pbActivity) {
        this.cbo = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.x.a
    public void onListPullRefresh(boolean z) {
        bk bkVar;
        cb cbVar;
        bkVar = this.cbo.caL;
        if (!bkVar.el(true)) {
            cbVar = this.cbo.caQ;
            cbVar.aeq();
            return;
        }
        TiebaStatic.eventStat(this.cbo.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
    }
}
