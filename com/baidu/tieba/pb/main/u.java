package com.baidu.tieba.pb.main;

import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bAS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(PbActivity pbActivity) {
        this.bAS = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.tbadkCore.location.i iVar;
        bz bzVar;
        com.baidu.tieba.tbadkCore.location.d dVar;
        bz bzVar2;
        bz bzVar3;
        if (UtilHelper.isNetOk()) {
            bzVar = this.bAS.bAw;
            if (bzVar.Fz() != null) {
                bzVar2 = this.bAS.bAw;
                bzVar2.Fz().setLocationInfoViewState(1);
                bzVar3 = this.bAS.bAw;
                bzVar3.Fz().setLocationViewVisibility(0);
            }
            dVar = this.bAS.aBC;
            dVar.aif();
        } else {
            iVar = this.bAS.aBN;
            iVar.Fr();
        }
        aVar.dismiss();
    }
}
