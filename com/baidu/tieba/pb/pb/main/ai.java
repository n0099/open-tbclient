package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
class ai implements com.baidu.tieba.tbadkCore.location.k {
    final /* synthetic */ PbActivity bIJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(PbActivity pbActivity) {
        this.bIJ = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.k
    public void IX() {
        cj cjVar;
        cj cjVar2;
        cjVar = this.bIJ.bIl;
        if (cjVar.Je() != null) {
            cjVar2 = this.bIJ.bIl;
            cjVar2.Je().setLocationViewVisibility(8);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.location.k
    public void fI(String str) {
        cj cjVar;
        cj cjVar2;
        cj cjVar3;
        cjVar = this.bIJ.bIl;
        if (cjVar.Je() != null) {
            cjVar2 = this.bIJ.bIl;
            cjVar2.Je().setLocationViewVisibility(0);
            cjVar3 = this.bIJ.bIl;
            cjVar3.Je().B(2, str);
        }
    }
}
