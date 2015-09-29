package com.baidu.tieba.pb.chosen;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* loaded from: classes.dex */
class m implements a.d {
    final /* synthetic */ PbChosenActivity cfa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(PbChosenActivity pbChosenActivity) {
        this.cfa = pbChosenActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.l lVar, WriteData writeData, AntiData antiData) {
        com.baidu.tbadk.editortools.c.d dVar;
        com.baidu.tieba.pb.chosen.a.m mVar;
        this.cfa.hideProgressBar();
        if (z) {
            dVar = this.cfa.aSr;
            dVar.Ax().hide();
            mVar = this.cfa.ceH;
            mVar.setVisible(true);
            if (postWriteCallBackData != null) {
                BdToast.a(this.cfa.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), BdToast.DefaultIcon.SUCCESS).sZ();
            }
        } else if (postWriteCallBackData != null && lVar == null) {
            if (AntiHelper.la(postWriteCallBackData.getErrorCode())) {
                AntiHelper.P(this.cfa.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else {
                BdToast.b(this.cfa.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString()).sZ();
            }
        }
    }
}
