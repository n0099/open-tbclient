package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.x;
/* loaded from: classes.dex */
class o implements x.a {
    final /* synthetic */ PbActivity ccj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(PbActivity pbActivity) {
        this.ccj = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.x.a
    public void onListPullRefresh(boolean z) {
        bk bkVar;
        cb cbVar;
        bkVar = this.ccj.cbG;
        if (!bkVar.et(true)) {
            cbVar = this.ccj.cbL;
            cbVar.aeE();
            return;
        }
        TiebaStatic.eventStat(this.ccj.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
    }
}
