package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements a.d {
    final /* synthetic */ az czi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(az azVar) {
        this.czi = azVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.o oVar, WriteData writeData, AntiData antiData) {
        com.baidu.tbadk.editortools.d.p pVar;
        bf bfVar;
        bf bfVar2;
        this.czi.cyh.hideProgressBar();
        pVar = this.czi.czd;
        pVar.Bb().hide();
        bfVar = this.czi.cyq;
        bfVar.alu();
        if (postWriteCallBackData != null && oVar == null && !AntiHelper.pw(postWriteCallBackData.getErrorCode())) {
            bfVar2 = this.czi.cyq;
            bfVar2.showToast(postWriteCallBackData.getErrorString());
        }
    }
}
