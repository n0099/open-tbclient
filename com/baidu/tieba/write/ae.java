package com.baidu.tieba.write;

import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ae implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ WriteActivity cgS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(WriteActivity writeActivity) {
        this.cgS = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.tbadkCore.location.i iVar;
        com.baidu.tieba.tbadkCore.PbEditor.k kVar;
        com.baidu.tieba.tbadkCore.location.d dVar;
        if (UtilHelper.isNetOk()) {
            kVar = this.cgS.cgz;
            kVar.setLocationInfoViewState(1);
            dVar = this.cgS.aBF;
            dVar.aik();
        } else {
            iVar = this.cgS.aBQ;
            iVar.Fx();
        }
        aVar.dismiss();
    }
}
