package com.baidu.tieba.pb.main;

import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bvu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PbActivity pbActivity) {
        this.bvu = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.location.i iVar;
        bv bvVar;
        com.baidu.tieba.location.d dVar;
        bv bvVar2;
        bv bvVar3;
        if (UtilHelper.isNetOk()) {
            bvVar = this.bvu.buZ;
            if (bvVar.EQ() != null) {
                bvVar2 = this.bvu.buZ;
                bvVar2.EQ().setLocationInfoViewState(1);
                bvVar3 = this.bvu.buZ;
                bvVar3.EQ().setLocationViewVisibility(0);
            }
            dVar = this.bvu.ayB;
            dVar.Sz();
        } else {
            iVar = this.bvu.ayM;
            iVar.EI();
        }
        aVar.dismiss();
    }
}
