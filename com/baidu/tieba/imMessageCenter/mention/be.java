package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements a.d {
    final /* synthetic */ az dhD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(az azVar) {
        this.dhD = azVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.p pVar, WriteData writeData, AntiData antiData) {
        com.baidu.tbadk.editortools.d.p pVar2;
        bf bfVar;
        bf bfVar2;
        this.dhD.dgz.hideProgressBar();
        pVar2 = this.dhD.dhw;
        pVar2.Bl().hide();
        bfVar = this.dhD.dgI;
        bfVar.auv();
        if (postWriteCallBackData != null && pVar == null && !AntiHelper.rg(postWriteCallBackData.getErrorCode())) {
            bfVar2 = this.dhD.dgI;
            bfVar2.showToast(postWriteCallBackData.getErrorString());
        }
    }
}
