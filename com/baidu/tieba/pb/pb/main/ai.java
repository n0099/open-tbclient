package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ab;
/* loaded from: classes.dex */
class ai implements ab.b {
    final /* synthetic */ PbActivity elO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(PbActivity pbActivity) {
        this.elO = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.ab.b
    public void aL(boolean z) {
        PbModel pbModel;
        fa faVar;
        if (this.elO.aKC()) {
            this.elO.finish();
        }
        pbModel = this.elO.ejZ;
        if (!pbModel.iq(true)) {
            faVar = this.elO.ekM;
            faVar.aNf();
            return;
        }
        TiebaStatic.eventStat(this.elO.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
    }
}
