package com.baidu.tieba.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bAS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(PbActivity pbActivity) {
        this.bAS = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        bz bzVar;
        bz bzVar2;
        bzVar = this.bAS.bAw;
        if (bzVar.Fz() != null) {
            bzVar2 = this.bAS.bAw;
            bzVar2.Fz().setLocationInfoViewState(0);
        }
        aVar.dismiss();
    }
}
