package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ae;
/* loaded from: classes.dex */
class am implements ae.b {
    final /* synthetic */ PbActivity enc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(PbActivity pbActivity) {
        this.enc = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.ae.b
    public void onListPullRefresh(boolean z) {
        PbModel pbModel;
        fx fxVar;
        if (this.enc.aJX()) {
            this.enc.finish();
        }
        pbModel = this.enc.ele;
        if (!pbModel.is(true)) {
            fxVar = this.enc.elU;
            fxVar.aMC();
            return;
        }
        TiebaStatic.eventStat(this.enc.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
    }
}
