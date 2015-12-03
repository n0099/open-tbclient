package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.q;
/* loaded from: classes.dex */
class s implements q.a {
    final /* synthetic */ PbActivity cCm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PbActivity pbActivity) {
        this.cCm = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.q.a
    public void onListPullRefresh(boolean z) {
        cc ccVar;
        da daVar;
        ccVar = this.cCm.cBG;
        if (!ccVar.fe(true)) {
            daVar = this.cCm.cBL;
            daVar.alC();
            return;
        }
        TiebaStatic.eventStat(this.cCm.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
    }
}
