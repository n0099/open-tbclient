package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
class at implements com.baidu.tieba.tbadkCore.location.k {
    final /* synthetic */ PbActivity bKT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(PbActivity pbActivity) {
        this.bKT = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.k
    public void JX() {
        ch chVar;
        ch chVar2;
        chVar = this.bKT.bKz;
        if (chVar.Ki() != null) {
            chVar2 = this.bKT.bKz;
            chVar2.Ki().setLocationViewVisibility(8);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.location.k
    public void gi(String str) {
        ch chVar;
        ch chVar2;
        ch chVar3;
        chVar = this.bKT.bKz;
        if (chVar.Ki() != null) {
            chVar2 = this.bKT.bKz;
            chVar2.Ki().setLocationViewVisibility(0);
            chVar3 = this.bKT.bKz;
            chVar3.Ki().D(2, str);
        }
    }
}
