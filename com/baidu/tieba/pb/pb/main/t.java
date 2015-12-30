package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.r;
/* loaded from: classes.dex */
class t implements r.a {
    final /* synthetic */ PbActivity cFS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PbActivity pbActivity) {
        this.cFS = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.r.a
    public void onListPullRefresh(boolean z) {
        cf cfVar;
        dk dkVar;
        cfVar = this.cFS.cFl;
        if (!cfVar.fd(true)) {
            dkVar = this.cFS.cFq;
            dkVar.amO();
            return;
        }
        TiebaStatic.eventStat(this.cFS.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
    }
}
