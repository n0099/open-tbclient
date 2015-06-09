package com.baidu.tieba.pb.pb.main;

import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ PbActivity bKU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(PbActivity pbActivity) {
        this.bKU = pbActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.tbadkCore.location.j jVar;
        ch chVar;
        com.baidu.tieba.tbadkCore.location.e eVar;
        ch chVar2;
        ch chVar3;
        if (UtilHelper.isNetOk()) {
            chVar = this.bKU.bKA;
            if (chVar.Kj() != null) {
                chVar2 = this.bKU.bKA;
                chVar2.Kj().setLocationInfoViewState(1);
                chVar3 = this.bKU.bKA;
                chVar3.Kj().setLocationViewVisibility(0);
            }
            eVar = this.bKU.aJN;
            eVar.apq();
        } else {
            jVar = this.bKU.aJY;
            jVar.JX();
        }
        aVar.dismiss();
    }
}
