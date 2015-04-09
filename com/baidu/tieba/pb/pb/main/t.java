package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
class t implements com.baidu.tbadk.core.view.y {
    final /* synthetic */ PbActivity bIJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PbActivity pbActivity) {
        this.bIJ = pbActivity;
    }

    @Override // com.baidu.tbadk.core.view.y
    public void an(boolean z) {
        boolean z2;
        br brVar;
        z2 = this.bIJ.bHS;
        if (!z2 && z) {
            brVar = this.bIJ.bIg;
            if (brVar.aaf()) {
                return;
            }
            this.bIJ.ZK();
        }
    }
}
