package com.baidu.tieba.pb.chosen;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* loaded from: classes.dex */
class m implements a.d {
    final /* synthetic */ PbChosenActivity cfM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(PbChosenActivity pbChosenActivity) {
        this.cfM = pbChosenActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.l lVar, WriteData writeData, AntiData antiData) {
        com.baidu.tbadk.editortools.c.e eVar;
        com.baidu.tieba.pb.chosen.a.m mVar;
        this.cfM.hideProgressBar();
        if (z) {
            eVar = this.cfM.aSK;
            eVar.Az().hide();
            mVar = this.cfM.cft;
            mVar.setVisible(true);
            if (postWriteCallBackData != null) {
                BdToast.a(this.cfM.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), BdToast.DefaultIcon.SUCCESS).sZ();
            }
        } else if (postWriteCallBackData != null && lVar == null) {
            if (AntiHelper.lr(postWriteCallBackData.getErrorCode())) {
                AntiHelper.Q(this.cfM.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else {
                BdToast.b(this.cfM.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString()).sZ();
            }
        }
    }
}
