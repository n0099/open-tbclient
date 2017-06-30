package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ae;
/* loaded from: classes.dex */
class ao implements ae.b {
    final /* synthetic */ PbActivity ewh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(PbActivity pbActivity) {
        this.ewh = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.ae.b
    public void onListPullRefresh(boolean z) {
        PbModel pbModel;
        gg ggVar;
        if (this.ewh.aNU()) {
            this.ewh.finish();
        }
        pbModel = this.ewh.eue;
        if (!pbModel.iO(true)) {
            ggVar = this.ewh.euU;
            ggVar.aQA();
            return;
        }
        TiebaStatic.eventStat(this.ewh.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
    }
}
