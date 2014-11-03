package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
class r implements com.baidu.tbadk.core.view.u {
    final /* synthetic */ PbActivity bvu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(PbActivity pbActivity) {
        this.bvu = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.u
    public void aa(boolean z) {
        boolean z2;
        bn bnVar;
        z2 = this.bvu.aiS;
        if (!z2 && z) {
            bnVar = this.bvu.buU;
            if (bnVar.WN()) {
                return;
            }
            this.bvu.Wu();
        }
    }
}
