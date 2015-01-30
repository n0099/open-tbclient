package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
class at implements com.baidu.tieba.tbadkCore.location.j {
    final /* synthetic */ PbActivity bAT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(PbActivity pbActivity) {
        this.bAT = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.j
    public void Fy() {
        bz bzVar;
        bz bzVar2;
        bzVar = this.bAT.bAx;
        if (bzVar.FF() != null) {
            bzVar2 = this.bAT.bAx;
            bzVar2.FF().setLocationViewVisibility(8);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.location.j
    public void fz(String str) {
        bz bzVar;
        bz bzVar2;
        bz bzVar3;
        bzVar = this.bAT.bAx;
        if (bzVar.FF() != null) {
            bzVar2 = this.bAT.bAx;
            bzVar2.FF().setLocationViewVisibility(0);
            bzVar3 = this.bAT.bAx;
            bzVar3.FF().B(2, str);
        }
    }
}
