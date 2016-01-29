package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.r;
/* loaded from: classes.dex */
class w implements r.a {
    final /* synthetic */ PbActivity cNq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(PbActivity pbActivity) {
        this.cNq = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.r.a
    public void az(boolean z) {
        cm cmVar;
        dz dzVar;
        cmVar = this.cNq.cMF;
        if (!cmVar.fs(true)) {
            dzVar = this.cNq.cMK;
            dzVar.arl();
            return;
        }
        TiebaStatic.eventStat(this.cNq.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
    }
}
