package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bIJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(PbActivity pbActivity) {
        this.bIJ = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        cj cjVar;
        cj cjVar2;
        cjVar = this.bIJ.bIl;
        if (cjVar.Je() != null) {
            cjVar2 = this.bIJ.bIl;
            cjVar2.Je().setLocationInfoViewState(0);
        }
        aVar.dismiss();
    }
}
