package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.y;
/* loaded from: classes.dex */
class aj implements y.b {
    final /* synthetic */ PbActivity eqa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(PbActivity pbActivity) {
        this.eqa = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.y.b
    public void aI(boolean z) {
        dh dhVar;
        ex exVar;
        if (this.eqa.aNE()) {
            this.eqa.finish();
        }
        dhVar = this.eqa.eov;
        if (!dhVar.ig(true)) {
            exVar = this.eqa.epe;
            exVar.aQc();
            return;
        }
        TiebaStatic.eventStat(this.eqa.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
    }
}
