package com.baidu.tieba.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bvu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PbActivity pbActivity) {
        this.bvu = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        bv bvVar;
        bv bvVar2;
        bvVar = this.bvu.buZ;
        if (bvVar.EQ() != null) {
            bvVar2 = this.bvu.buZ;
            bvVar2.EQ().setLocationInfoViewState(0);
        }
        aVar.dismiss();
    }
}
