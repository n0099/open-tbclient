package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ak implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ WriteActivity cCQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ak(WriteActivity writeActivity) {
        this.cCQ = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.tbadkCore.location.j jVar;
        com.baidu.tieba.write.editor.b bVar;
        com.baidu.tieba.tbadkCore.location.e eVar;
        if (UtilHelper.isNetOk()) {
            bVar = this.cCQ.cCx;
            bVar.setLocationInfoViewState(1);
            eVar = this.cCQ.aJN;
            eVar.apq();
        } else {
            jVar = this.cCQ.aJY;
            jVar.JX();
        }
        aVar.dismiss();
    }
}
