package com.baidu.tieba.pb.main;

import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bvg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PbActivity pbActivity) {
        this.bvg = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.location.i iVar;
        bv bvVar;
        com.baidu.tieba.location.d dVar;
        bv bvVar2;
        bv bvVar3;
        if (UtilHelper.isNetOk()) {
            bvVar = this.bvg.buL;
            if (bvVar.EO() != null) {
                bvVar2 = this.bvg.buL;
                bvVar2.EO().setLocationInfoViewState(1);
                bvVar3 = this.bvg.buL;
                bvVar3.EO().setLocationViewVisibility(0);
            }
            dVar = this.bvg.ays;
            dVar.Sw();
        } else {
            iVar = this.bvg.ayD;
            iVar.EG();
        }
        aVar.dismiss();
    }
}
