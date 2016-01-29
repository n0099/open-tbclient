package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bc implements a.d {
    final /* synthetic */ ax cnH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(ax axVar) {
        this.cnH = axVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.n nVar, WriteData writeData, AntiData antiData) {
        com.baidu.tbadk.editortools.d.p pVar;
        bd bdVar;
        bd bdVar2;
        this.cnH.cmH.hideProgressBar();
        pVar = this.cnH.cnC;
        pVar.Cz().hide();
        bdVar = this.cnH.cmQ;
        bdVar.ahT();
        if (postWriteCallBackData != null && nVar == null && !AntiHelper.or(postWriteCallBackData.getErrorCode())) {
            bdVar2 = this.cnH.cmQ;
            bdVar2.showToast(postWriteCallBackData.getErrorString());
        }
    }
}
