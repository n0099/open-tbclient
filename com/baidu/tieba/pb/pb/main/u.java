package com.baidu.tieba.pb.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bIv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(PbActivity pbActivity) {
        this.bIv = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        ci ciVar;
        ci ciVar2;
        ciVar = this.bIv.bHY;
        if (ciVar.IY() != null) {
            ciVar2 = this.bIv.bHY;
            ciVar2.IY().setLocationInfoViewState(0);
        }
        aVar.dismiss();
    }
}
