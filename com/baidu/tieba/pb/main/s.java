package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
class s implements com.baidu.tbadk.core.view.ad {
    final /* synthetic */ PbActivity bzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PbActivity pbActivity) {
        this.bzj = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.ad
    public void ar(boolean z) {
        boolean z2;
        bq bqVar;
        z2 = this.bzj.aqe;
        if (!z2 && z) {
            bqVar = this.bzj.byJ;
            if (bqVar.Xk()) {
                return;
            }
            this.bzj.WR();
        }
    }
}
