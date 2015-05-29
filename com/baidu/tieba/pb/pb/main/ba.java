package com.baidu.tieba.pb.pb.main;
/* loaded from: classes.dex */
class ba implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bKT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ba(PbActivity pbActivity) {
        this.bKT = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        bo boVar;
        ch chVar;
        ch chVar2;
        ch chVar3;
        bo boVar2;
        ch chVar4;
        this.bKT.KD();
        boVar = this.bKT.bKv;
        com.baidu.tbadk.core.data.q abu = boVar.abu();
        chVar = this.bKT.bKz;
        int pageNum = chVar.getPageNum();
        if (pageNum <= 0) {
            this.bKT.showToast(com.baidu.tieba.t.pb_page_error);
        } else if (abu == null || pageNum <= abu.qN()) {
            chVar2 = this.bKT.bKz;
            chVar2.acw();
            this.bKT.stopVoice();
            chVar3 = this.bKT.bKz;
            chVar3.acf();
            boVar2 = this.bKT.bKv;
            chVar4 = this.bKT.bKz;
            boVar2.hA(chVar4.getPageNum());
            aVar.dismiss();
        } else {
            this.bKT.showToast(com.baidu.tieba.t.pb_page_error);
        }
    }
}
