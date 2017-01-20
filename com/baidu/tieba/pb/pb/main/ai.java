package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.aa;
/* loaded from: classes.dex */
class ai implements aa.b {
    final /* synthetic */ PbActivity eiV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(PbActivity pbActivity) {
        this.eiV = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.aa.b
    public void aM(boolean z) {
        PbModel pbModel;
        ez ezVar;
        if (this.eiV.aLh()) {
            this.eiV.finish();
        }
        pbModel = this.eiV.ehh;
        if (!pbModel.iv(true)) {
            ezVar = this.eiV.ehV;
            ezVar.aNM();
            return;
        }
        TiebaStatic.eventStat(this.eiV.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
    }
}
