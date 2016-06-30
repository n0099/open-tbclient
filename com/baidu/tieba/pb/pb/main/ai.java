package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.t;
/* loaded from: classes.dex */
class ai implements t.b {
    final /* synthetic */ PbActivity dPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(PbActivity pbActivity) {
        this.dPF = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.t.b
    public void aE(boolean z) {
        dg dgVar;
        es esVar;
        if (this.dPF.aEV()) {
            this.dPF.finish();
        }
        dgVar = this.dPF.dOf;
        if (!dgVar.hx(true)) {
            esVar = this.dPF.dOO;
            esVar.aHr();
            return;
        }
        TiebaStatic.eventStat(this.dPF.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
    }
}
