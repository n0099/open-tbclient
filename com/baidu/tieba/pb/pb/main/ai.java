package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.t;
/* loaded from: classes.dex */
class ai implements t.b {
    final /* synthetic */ PbActivity ebT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(PbActivity pbActivity) {
        this.ebT = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.t.b
    public void aH(boolean z) {
        dh dhVar;
        ew ewVar;
        if (this.ebT.aIg()) {
            this.ebT.finish();
        }
        dhVar = this.ebT.eas;
        if (!dhVar.hI(true)) {
            ewVar = this.ebT.ebb;
            ewVar.aKC();
            return;
        }
        TiebaStatic.eventStat(this.ebT.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
    }
}
