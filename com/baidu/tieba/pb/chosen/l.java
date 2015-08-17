package com.baidu.tieba.pb.chosen;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* loaded from: classes.dex */
class l implements a.d {
    final /* synthetic */ PbChosenActivity bYY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PbChosenActivity pbChosenActivity) {
        this.bYY = pbChosenActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.l lVar, WriteData writeData, AntiData antiData) {
        com.baidu.tbadk.editortools.c.d dVar;
        com.baidu.tieba.pb.chosen.a.m mVar;
        this.bYY.hideProgressBar();
        if (z) {
            dVar = this.bYY.aTh;
            dVar.Ay().hide();
            mVar = this.bYY.bYF;
            mVar.setVisible(true);
            if (postWriteCallBackData != null) {
                BdToast.a(this.bYY.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), BdToast.DefaultIcon.SUCCESS).sX();
            }
        } else if (postWriteCallBackData != null && lVar == null) {
            BdToast.b(this.bYY.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString()).sX();
        }
    }
}
