package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bKT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PbActivity pbActivity) {
        this.bKT = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.tbadkCore.location.j jVar;
        ch chVar;
        com.baidu.tieba.tbadkCore.location.e eVar;
        ch chVar2;
        ch chVar3;
        if (UtilHelper.isNetOk()) {
            chVar = this.bKT.bKz;
            if (chVar.Ki() != null) {
                chVar2 = this.bKT.bKz;
                chVar2.Ki().setLocationInfoViewState(1);
                chVar3 = this.bKT.bKz;
                chVar3.Ki().setLocationViewVisibility(0);
            }
            eVar = this.bKT.aJM;
            eVar.app();
        } else {
            jVar = this.bKT.aJX;
            jVar.JW();
        }
        aVar.dismiss();
    }
}
