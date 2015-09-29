package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes.dex */
class n implements PbActivity.b {
    final /* synthetic */ PbActivity ciz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(PbActivity pbActivity) {
        this.ciz = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.PbActivity.b
    public void ev(boolean z) {
        bl blVar;
        cc ccVar;
        blVar = this.ciz.chV;
        if (blVar.ey(true)) {
            ccVar = this.ciz.cia;
            ccVar.agA();
        }
    }
}
