package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
class r implements com.baidu.tbadk.core.view.ad {
    final /* synthetic */ PbActivity bKT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(PbActivity pbActivity) {
        this.bKT = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.ad
    public void au(boolean z) {
        boolean z2;
        bo boVar;
        z2 = this.bKT.bKh;
        if (!z2 && z) {
            boVar = this.bKT.bKv;
            if (boVar.abt()) {
                return;
            }
            this.bKT.abb();
        }
    }
}
