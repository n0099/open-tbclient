package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.z;
/* loaded from: classes.dex */
class ai implements z.b {
    final /* synthetic */ PbActivity eah;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(PbActivity pbActivity) {
        this.eah = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.z.b
    public void aM(boolean z) {
        dc dcVar;
        er erVar;
        if (this.eah.aJu()) {
            this.eah.finish();
        }
        dcVar = this.eah.dYA;
        if (!dcVar.il(true)) {
            erVar = this.eah.dZk;
            erVar.aLX();
            return;
        }
        TiebaStatic.eventStat(this.eah.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
    }
}
