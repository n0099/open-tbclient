package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bKT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PbActivity pbActivity) {
        this.bKT = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        ch chVar;
        ch chVar2;
        chVar = this.bKT.bKz;
        if (chVar.Ki() != null) {
            chVar2 = this.bKT.bKz;
            chVar2.Ki().setLocationInfoViewState(0);
        }
        aVar.dismiss();
    }
}
