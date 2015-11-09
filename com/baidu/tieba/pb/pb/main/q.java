package com.baidu.tieba.pb.pb.main;

import com.baidu.tieba.pb.pb.main.PbActivity;
/* loaded from: classes.dex */
class q implements PbActivity.b {
    final /* synthetic */ PbActivity cjN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(PbActivity pbActivity) {
        this.cjN = pbActivity;
    }

    @Override // com.baidu.tieba.pb.pb.main.PbActivity.b
    public void ey(boolean z) {
        ca caVar;
        ct ctVar;
        caVar = this.cjN.cjj;
        if (caVar.eB(true)) {
            ctVar = this.cjN.cjo;
            ctVar.ahc();
        }
    }
}
