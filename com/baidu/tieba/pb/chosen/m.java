package com.baidu.tieba.pb.chosen;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* loaded from: classes.dex */
class m implements a.d {
    final /* synthetic */ PbChosenActivity cfl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(PbChosenActivity pbChosenActivity) {
        this.cfl = pbChosenActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.l lVar, WriteData writeData, AntiData antiData) {
        com.baidu.tbadk.editortools.c.d dVar;
        com.baidu.tieba.pb.chosen.a.m mVar;
        this.cfl.hideProgressBar();
        if (z) {
            dVar = this.cfl.aSC;
            dVar.Au().hide();
            mVar = this.cfl.ceS;
            mVar.setVisible(true);
            if (postWriteCallBackData != null) {
                BdToast.a(this.cfl.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), BdToast.DefaultIcon.SUCCESS).sW();
            }
        } else if (postWriteCallBackData != null && lVar == null) {
            if (AntiHelper.lc(postWriteCallBackData.getErrorCode())) {
                AntiHelper.P(this.cfl.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else {
                BdToast.b(this.cfl.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString()).sW();
            }
        }
    }
}
