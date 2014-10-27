package com.baidu.tieba.write;

import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ WriteActivity bTX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(WriteActivity writeActivity) {
        this.bTX = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.location.i iVar;
        com.baidu.tieba.editortool.j jVar;
        com.baidu.tieba.location.d dVar;
        if (UtilHelper.isNetOk()) {
            jVar = this.bTX.bTE;
            jVar.setLocationInfoViewState(1);
            dVar = this.bTX.ays;
            dVar.Sw();
        } else {
            iVar = this.bTX.ayD;
            iVar.EG();
        }
        aVar.dismiss();
    }
}
