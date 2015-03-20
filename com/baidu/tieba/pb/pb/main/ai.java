package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
class ai implements com.baidu.tieba.tbadkCore.location.k {
    final /* synthetic */ PbActivity bIv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(PbActivity pbActivity) {
        this.bIv = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.k
    public void IR() {
        ci ciVar;
        ci ciVar2;
        ciVar = this.bIv.bHY;
        if (ciVar.IY() != null) {
            ciVar2 = this.bIv.bHY;
            ciVar2.IY().setLocationViewVisibility(8);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.location.k
    public void fF(String str) {
        ci ciVar;
        ci ciVar2;
        ci ciVar3;
        ciVar = this.bIv.bHY;
        if (ciVar.IY() != null) {
            ciVar2 = this.bIv.bHY;
            ciVar2.IY().setLocationViewVisibility(0);
            ciVar3 = this.bIv.bHY;
            ciVar3.IY().B(2, str);
        }
    }
}
