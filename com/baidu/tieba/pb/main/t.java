package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
class t implements com.baidu.tbadk.core.view.ad {
    final /* synthetic */ PbActivity bAS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PbActivity pbActivity) {
        this.bAS = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.ad
    public void at(boolean z) {
        boolean z2;
        bq bqVar;
        z2 = this.bAS.are;
        if (!z2 && z) {
            bqVar = this.bAS.bAr;
            if (bqVar.XK()) {
                return;
            }
            this.bAS.Xr();
        }
    }
}
