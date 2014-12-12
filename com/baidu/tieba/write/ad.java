package com.baidu.tieba.write;

import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ WriteActivity cft;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(WriteActivity writeActivity) {
        this.cft = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.tbadkCore.location.i iVar;
        com.baidu.tieba.tbadkCore.PbEditor.k kVar;
        com.baidu.tieba.tbadkCore.location.d dVar;
        if (UtilHelper.isNetOk()) {
            kVar = this.cft.cfa;
            kVar.setLocationInfoViewState(1);
            dVar = this.cft.aAD;
            dVar.ahG();
        } else {
            iVar = this.cft.aAO;
            iVar.EZ();
        }
        aVar.dismiss();
    }
}
