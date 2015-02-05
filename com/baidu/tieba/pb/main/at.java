package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
class at implements com.baidu.tieba.tbadkCore.location.j {
    final /* synthetic */ PbActivity bAS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(PbActivity pbActivity) {
        this.bAS = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.j
    public void Fs() {
        bz bzVar;
        bz bzVar2;
        bzVar = this.bAS.bAw;
        if (bzVar.Fz() != null) {
            bzVar2 = this.bAS.bAw;
            bzVar2.Fz().setLocationViewVisibility(8);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.location.j
    public void fw(String str) {
        bz bzVar;
        bz bzVar2;
        bz bzVar3;
        bzVar = this.bAS.bAw;
        if (bzVar.Fz() != null) {
            bzVar2 = this.bAS.bAw;
            bzVar2.Fz().setLocationViewVisibility(0);
            bzVar3 = this.bAS.bAw;
            bzVar3.Fz().B(2, str);
        }
    }
}
