package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
class ba implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bKU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(PbActivity pbActivity) {
        this.bKU = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        bo boVar;
        ch chVar;
        ch chVar2;
        ch chVar3;
        bo boVar2;
        ch chVar4;
        this.bKU.KE();
        boVar = this.bKU.bKw;
        com.baidu.tbadk.core.data.q abv = boVar.abv();
        chVar = this.bKU.bKA;
        int pageNum = chVar.getPageNum();
        if (pageNum <= 0) {
            this.bKU.showToast(com.baidu.tieba.t.pb_page_error);
        } else if (abv == null || pageNum <= abv.qN()) {
            chVar2 = this.bKU.bKA;
            chVar2.acx();
            this.bKU.stopVoice();
            chVar3 = this.bKU.bKA;
            chVar3.acg();
            boVar2 = this.bKU.bKw;
            chVar4 = this.bKU.bKA;
            boVar2.hA(chVar4.getPageNum());
            aVar.dismiss();
        } else {
            this.bKU.showToast(com.baidu.tieba.t.pb_page_error);
        }
    }
}
