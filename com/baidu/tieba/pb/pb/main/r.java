package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
class r implements com.baidu.tbadk.core.view.ad {
    final /* synthetic */ PbActivity bKU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(PbActivity pbActivity) {
        this.bKU = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.ad
    public void au(boolean z) {
        boolean z2;
        bo boVar;
        z2 = this.bKU.bKi;
        if (!z2 && z) {
            boVar = this.bKU.bKw;
            if (boVar.abu()) {
                return;
            }
            this.bKU.abc();
        }
    }
}
