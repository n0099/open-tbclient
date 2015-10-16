package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.p;
/* loaded from: classes.dex */
class o implements p.a {
    final /* synthetic */ PbActivity ciK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(PbActivity pbActivity) {
        this.ciK = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.p.a
    public void onListPullRefresh(boolean z) {
        bl blVar;
        cc ccVar;
        blVar = this.ciK.cih;
        if (!blVar.ey(true)) {
            ccVar = this.ciK.cim;
            ccVar.agC();
            return;
        }
        TiebaStatic.eventStat(this.ciK.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
    }
}
