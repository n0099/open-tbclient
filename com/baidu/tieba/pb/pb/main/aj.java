package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ae;
/* loaded from: classes.dex */
class aj implements ae.b {
    final /* synthetic */ PbActivity ehy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(PbActivity pbActivity) {
        this.ehy = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.ae.b
    public void aM(boolean z) {
        PbModel pbModel;
        fm fmVar;
        if (this.ehy.aJf()) {
            this.ehy.finish();
        }
        pbModel = this.ehy.efE;
        if (!pbModel.id(true)) {
            fmVar = this.ehy.egt;
            fmVar.aLG();
            return;
        }
        TiebaStatic.eventStat(this.ehy.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
    }
}
