package com.baidu.tieba.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bAT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(PbActivity pbActivity) {
        this.bAT = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        bz bzVar;
        bz bzVar2;
        bzVar = this.bAT.bAx;
        if (bzVar.FF() != null) {
            bzVar2 = this.bAT.bAx;
            bzVar2.FF().setLocationInfoViewState(0);
        }
        aVar.dismiss();
    }
}
