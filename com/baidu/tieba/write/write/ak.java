package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ WriteActivity cCP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(WriteActivity writeActivity) {
        this.cCP = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.tbadkCore.location.j jVar;
        com.baidu.tieba.write.editor.b bVar;
        com.baidu.tieba.tbadkCore.location.e eVar;
        if (UtilHelper.isNetOk()) {
            bVar = this.cCP.cCw;
            bVar.setLocationInfoViewState(1);
            eVar = this.cCP.aJM;
            eVar.app();
        } else {
            jVar = this.cCP.aJX;
            jVar.JW();
        }
        aVar.dismiss();
    }
}
