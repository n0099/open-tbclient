package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class be implements b.d {
    final /* synthetic */ az dti;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(az azVar) {
        this.dti = azVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.b.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.s sVar, WriteData writeData, AntiData antiData) {
        com.baidu.tbadk.editortools.d.p pVar;
        bf bfVar;
        bf bfVar2;
        this.dti.dsf.hideProgressBar();
        pVar = this.dti.dtc;
        pVar.CG().hide();
        bfVar = this.dti.dso;
        bfVar.azi();
        if (postWriteCallBackData != null && sVar == null && !AntiHelper.rG(postWriteCallBackData.getErrorCode())) {
            bfVar2 = this.dti.dso;
            bfVar2.showToast(postWriteCallBackData.getErrorString());
        }
    }
}
