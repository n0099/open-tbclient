package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements b.d {
    final /* synthetic */ az dAk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(az azVar) {
        this.dAk = azVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.b.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.s sVar, WriteData writeData, AntiData antiData) {
        com.baidu.tbadk.editortools.e.p pVar;
        bf bfVar;
        bf bfVar2;
        this.dAk.dzh.hideProgressBar();
        pVar = this.dAk.dAe;
        pVar.CO().hide();
        bfVar = this.dAk.dzq;
        bfVar.aBC();
        if (postWriteCallBackData != null && sVar == null && !AntiHelper.sm(postWriteCallBackData.getErrorCode())) {
            bfVar2 = this.dAk.dzq;
            bfVar2.showToast(postWriteCallBackData.getErrorString());
        }
    }
}
