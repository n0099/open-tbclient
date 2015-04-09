package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class j implements com.baidu.tbadk.core.view.ae {
    final /* synthetic */ PbActivity bIJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(PbActivity pbActivity) {
        this.bIJ = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.ae
    public void onListPullRefresh(boolean z) {
        br brVar;
        cj cjVar;
        brVar = this.bIJ.bIg;
        if (!brVar.dL(true)) {
            cjVar = this.bIJ.bIl;
            cjVar.abb();
            return;
        }
        TiebaStatic.eventStat(this.bIJ.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
    }
}
