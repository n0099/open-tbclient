package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.p;
/* loaded from: classes.dex */
class r implements p.a {
    final /* synthetic */ PbActivity cjN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(PbActivity pbActivity) {
        this.cjN = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.p.a
    public void onListPullRefresh(boolean z) {
        ca caVar;
        ct ctVar;
        caVar = this.cjN.cjj;
        if (!caVar.eB(true)) {
            ctVar = this.cjN.cjo;
            ctVar.ahe();
            return;
        }
        TiebaStatic.eventStat(this.cjN.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
    }
}
