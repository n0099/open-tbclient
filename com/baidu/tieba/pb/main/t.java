package com.baidu.tieba.pb.main;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bvg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(PbActivity pbActivity) {
        this.bvg = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        bv bvVar;
        bv bvVar2;
        bvVar = this.bvg.buL;
        if (bvVar.EO() != null) {
            bvVar2 = this.bvg.buL;
            bvVar2.EO().setLocationInfoViewState(0);
        }
        aVar.dismiss();
    }
}
