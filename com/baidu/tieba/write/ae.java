package com.baidu.tieba.write;

import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ WriteActivity cgR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(WriteActivity writeActivity) {
        this.cgR = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.tbadkCore.location.i iVar;
        com.baidu.tieba.tbadkCore.PbEditor.k kVar;
        com.baidu.tieba.tbadkCore.location.d dVar;
        if (UtilHelper.isNetOk()) {
            kVar = this.cgR.cgy;
            kVar.setLocationInfoViewState(1);
            dVar = this.cgR.aBC;
            dVar.aif();
        } else {
            iVar = this.cgR.aBN;
            iVar.Fr();
        }
        aVar.dismiss();
    }
}
