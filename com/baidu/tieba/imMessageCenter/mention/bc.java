package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements a.d {
    final /* synthetic */ ax cjh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(ax axVar) {
        this.cjh = axVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.n nVar, WriteData writeData, AntiData antiData) {
        com.baidu.tbadk.editortools.d.p pVar;
        bd bdVar;
        bd bdVar2;
        this.cjh.cih.hideProgressBar();
        pVar = this.cjh.cjc;
        pVar.Bj().hide();
        bdVar = this.cjh.ciq;
        bdVar.aeK();
        if (postWriteCallBackData != null && nVar == null && !AntiHelper.ne(postWriteCallBackData.getErrorCode())) {
            bdVar2 = this.cjh.ciq;
            bdVar2.showToast(postWriteCallBackData.getErrorString());
        }
    }
}
