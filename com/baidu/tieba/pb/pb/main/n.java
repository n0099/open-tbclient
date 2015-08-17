package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes.dex */
class n implements PbActivity.b {
    final /* synthetic */ PbActivity cbo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(PbActivity pbActivity) {
        this.cbo = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.PbActivity.b
    public void eg(boolean z) {
        bk bkVar;
        cb cbVar;
        bkVar = this.cbo.caL;
        if (bkVar.el(true)) {
            cbVar = this.cbo.caQ;
            cbVar.aeo();
        }
    }
}
