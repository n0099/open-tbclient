package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes.dex */
class r implements PbActivity.b {
    final /* synthetic */ PbActivity cCm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(PbActivity pbActivity) {
        this.cCm = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.PbActivity.b
    public void fb(boolean z) {
        cc ccVar;
        da daVar;
        ccVar = this.cCm.cBG;
        if (ccVar.fe(true)) {
            daVar = this.cCm.cBL;
            daVar.alA();
        }
    }
}
