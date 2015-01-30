package com.baidu.tieba.pb.main;

import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bAT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(PbActivity pbActivity) {
        this.bAT = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.tbadkCore.location.i iVar;
        bz bzVar;
        com.baidu.tieba.tbadkCore.location.d dVar;
        bz bzVar2;
        bz bzVar3;
        if (UtilHelper.isNetOk()) {
            bzVar = this.bAT.bAx;
            if (bzVar.FF() != null) {
                bzVar2 = this.bAT.bAx;
                bzVar2.FF().setLocationInfoViewState(1);
                bzVar3 = this.bAT.bAx;
                bzVar3.FF().setLocationViewVisibility(0);
            }
            dVar = this.bAT.aBF;
            dVar.aik();
        } else {
            iVar = this.bAT.aBQ;
            iVar.Fx();
        }
        aVar.dismiss();
    }
}
