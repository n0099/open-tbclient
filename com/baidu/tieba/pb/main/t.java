package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
class t implements com.baidu.tbadk.core.view.ad {
    final /* synthetic */ PbActivity bAT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PbActivity pbActivity) {
        this.bAT = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.ad
    public void at(boolean z) {
        boolean z2;
        bq bqVar;
        z2 = this.bAT.arh;
        if (!z2 && z) {
            bqVar = this.bAT.bAs;
            if (bqVar.XP()) {
                return;
            }
            this.bAT.Xw();
        }
    }
}
