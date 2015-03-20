package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
class s implements com.baidu.tbadk.core.view.y {
    final /* synthetic */ PbActivity bIv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PbActivity pbActivity) {
        this.bIv = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.y
    public void an(boolean z) {
        boolean z2;
        bq bqVar;
        z2 = this.bIv.bHF;
        if (!z2 && z) {
            bqVar = this.bIv.bHT;
            if (bqVar.ZS()) {
                return;
            }
            this.bIv.Zx();
        }
    }
}
