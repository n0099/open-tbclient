package com.baidu.tieba.write;

import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ WriteActivity bUm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(WriteActivity writeActivity) {
        this.bUm = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.location.i iVar;
        com.baidu.tieba.editortool.j jVar;
        com.baidu.tieba.location.d dVar;
        if (UtilHelper.isNetOk()) {
            jVar = this.bUm.bTT;
            jVar.setLocationInfoViewState(1);
            dVar = this.bUm.ayB;
            dVar.Sz();
        } else {
            iVar = this.bUm.ayM;
            iVar.EI();
        }
        aVar.dismiss();
    }
}
