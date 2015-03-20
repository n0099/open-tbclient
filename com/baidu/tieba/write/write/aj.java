package com.baidu.tieba.write.write;

import com.baidu.tbadk.core.util.UtilHelper;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ WriteActivity cyc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aj(WriteActivity writeActivity) {
        this.cyc = writeActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        com.baidu.tieba.tbadkCore.location.j jVar;
        com.baidu.tieba.write.editor.b bVar;
        com.baidu.tieba.tbadkCore.location.e eVar;
        if (UtilHelper.isNetOk()) {
            bVar = this.cyc.cxJ;
            bVar.setLocationInfoViewState(1);
            eVar = this.cyc.aHv;
            eVar.anj();
        } else {
            jVar = this.cyc.aHH;
            jVar.IQ();
        }
        aVar.dismiss();
    }
}
