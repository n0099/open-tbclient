package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.t;
/* loaded from: classes.dex */
class aj implements t.b {
    final /* synthetic */ PbActivity eob;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(PbActivity pbActivity) {
        this.eob = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.t.b
    public void aI(boolean z) {
        dh dhVar;
        ex exVar;
        if (this.eob.aMY()) {
            this.eob.finish();
        }
        dhVar = this.eob.emx;
        if (!dhVar.id(true)) {
            exVar = this.eob.enh;
            exVar.aPt();
            return;
        }
        TiebaStatic.eventStat(this.eob.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
    }
}
