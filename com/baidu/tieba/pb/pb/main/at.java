package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
class at implements com.baidu.tieba.tbadkCore.location.k {
    final /* synthetic */ PbActivity bKU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(PbActivity pbActivity) {
        this.bKU = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.k
    public void JY() {
        ch chVar;
        ch chVar2;
        chVar = this.bKU.bKA;
        if (chVar.Kj() != null) {
            chVar2 = this.bKU.bKA;
            chVar2.Kj().setLocationViewVisibility(8);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.location.k
    public void gi(String str) {
        ch chVar;
        ch chVar2;
        ch chVar3;
        chVar = this.bKU.bKA;
        if (chVar.Kj() != null) {
            chVar2 = this.bKU.bKA;
            chVar2.Kj().setLocationViewVisibility(0);
            chVar3 = this.bKU.bKA;
            chVar3.Kj().D(2, str);
        }
    }
}
