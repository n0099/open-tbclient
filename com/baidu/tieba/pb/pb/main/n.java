package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes.dex */
class n implements PbActivity.b {
    final /* synthetic */ PbActivity ciK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(PbActivity pbActivity) {
        this.ciK = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.PbActivity.b
    public void ev(boolean z) {
        bl blVar;
        cc ccVar;
        blVar = this.ciK.cih;
        if (blVar.ey(true)) {
            ccVar = this.ciK.cim;
            ccVar.agw();
        }
    }
}
