package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements a.d {
    final /* synthetic */ aw cfd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(aw awVar) {
        this.cfd = awVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.n nVar, WriteData writeData, AntiData antiData) {
        com.baidu.tbadk.editortools.d.p pVar;
        bc bcVar;
        bc bcVar2;
        this.cfd.ceg.hideProgressBar();
        pVar = this.cfd.ceY;
        pVar.Bu().hide();
        bcVar = this.cfd.cep;
        bcVar.adC();
        if (postWriteCallBackData != null && nVar == null && !AntiHelper.mC(postWriteCallBackData.getErrorCode())) {
            bcVar2 = this.cfd.cep;
            bcVar2.showToast(postWriteCallBackData.getErrorString());
        }
    }
}
