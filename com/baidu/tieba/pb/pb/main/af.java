package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.t;
/* loaded from: classes.dex */
class af implements t.b {
    final /* synthetic */ PbActivity djE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(PbActivity pbActivity) {
        this.djE = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.t.b
    public void aG(boolean z) {
        cw cwVar;
        el elVar;
        if (this.djE.awM()) {
            this.djE.finish();
        }
        cwVar = this.djE.dih;
        if (!cwVar.gF(true)) {
            elVar = this.djE.diR;
            elVar.aze();
            return;
        }
        TiebaStatic.eventStat(this.djE.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
    }
}
