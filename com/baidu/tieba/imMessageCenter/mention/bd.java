package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements a.d {
    final /* synthetic */ ay cyj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(ay ayVar) {
        this.cyj = ayVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.n nVar, WriteData writeData, AntiData antiData) {
        com.baidu.tbadk.editortools.d.p pVar;
        be beVar;
        be beVar2;
        this.cyj.cxj.hideProgressBar();
        pVar = this.cyj.cye;
        pVar.Dh().hide();
        beVar = this.cyj.cxs;
        beVar.aln();
        if (postWriteCallBackData != null && nVar == null && !AntiHelper.pB(postWriteCallBackData.getErrorCode())) {
            beVar2 = this.cyj.cxs;
            beVar2.showToast(postWriteCallBackData.getErrorString());
        }
    }
}
