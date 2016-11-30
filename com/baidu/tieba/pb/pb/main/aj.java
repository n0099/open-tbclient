package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.z;
/* loaded from: classes.dex */
class aj implements z.b {
    final /* synthetic */ PbActivity evL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(PbActivity pbActivity) {
        this.evL = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.z.b
    public void aL(boolean z) {
        dj djVar;
        ey eyVar;
        if (this.evL.aPv()) {
            this.evL.finish();
        }
        djVar = this.evL.euf;
        if (!djVar.iy(true)) {
            eyVar = this.evL.euP;
            eyVar.aSd();
            return;
        }
        TiebaStatic.eventStat(this.evL.getPageContext().getPageActivity(), "pb_pulldown", "pbclick", 1, new Object[0]);
    }
}
