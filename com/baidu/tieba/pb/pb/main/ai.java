package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ab;
/* loaded from: classes.dex */
class ai implements ab.b {
    final /* synthetic */ PbActivity ejU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(PbActivity pbActivity) {
        this.ejU = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.ab.b
    public void aN(boolean z) {
        PbModel pbModel;
        ey eyVar;
        if (this.ejU.aKI()) {
            this.ejU.finish();
        }
        pbModel = this.ejU.eif;
        if (!pbModel.ip(true)) {
            eyVar = this.ejU.eiS;
            eyVar.aNo();
            return;
        }
        TiebaStatic.eventStat(this.ejU.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
    }
}
