package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bKU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PbActivity pbActivity) {
        this.bKU = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        ch chVar;
        ch chVar2;
        chVar = this.bKU.bKA;
        if (chVar.Kj() != null) {
            chVar2 = this.bKU.bKA;
            chVar2.Kj().setLocationInfoViewState(0);
        }
        aVar.dismiss();
    }
}
