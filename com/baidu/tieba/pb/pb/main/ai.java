package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ab;
/* loaded from: classes.dex */
class ai implements ab.b {
    final /* synthetic */ PbActivity emk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(PbActivity pbActivity) {
        this.emk = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.ab.b
    public void aN(boolean z) {
        PbModel pbModel;
        ey eyVar;
        if (this.emk.aLI()) {
            this.emk.finish();
        }
        pbModel = this.emk.ekv;
        if (!pbModel.iz(true)) {
            eyVar = this.emk.eli;
            eyVar.aOp();
            return;
        }
        TiebaStatic.eventStat(this.emk.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
    }
}
