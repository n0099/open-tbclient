package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes.dex */
class n implements PbActivity.b {
    final /* synthetic */ PbActivity ccj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(PbActivity pbActivity) {
        this.ccj = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.PbActivity.b
    public void en(boolean z) {
        bk bkVar;
        cb cbVar;
        bkVar = this.ccj.cbG;
        if (bkVar.et(true)) {
            cbVar = this.ccj.cbL;
            cbVar.aeC();
        }
    }
}
