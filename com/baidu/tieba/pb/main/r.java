package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
class r implements com.baidu.tbadk.core.view.u {
    final /* synthetic */ PbActivity bvg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(PbActivity pbActivity) {
        this.bvg = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.u
    public void aa(boolean z) {
        boolean z2;
        bn bnVar;
        z2 = this.bvg.aiJ;
        if (!z2 && z) {
            bnVar = this.bvg.buG;
            if (bnVar.WK()) {
                return;
            }
            this.bvg.Wr();
        }
    }
}
