package com.baidu.tieba.pb.chosen;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* loaded from: classes.dex */
class n implements a.d {
    final /* synthetic */ PbChosenActivity cIA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(PbChosenActivity pbChosenActivity) {
        this.cIA = pbChosenActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.n nVar, WriteData writeData, AntiData antiData) {
        com.baidu.tbadk.editortools.d.e eVar;
        com.baidu.tieba.pb.chosen.a.l lVar;
        this.cIA.hideProgressBar();
        if (z) {
            eVar = this.cIA.bej;
            eVar.Cz().hide();
            lVar = this.cIA.cIg;
            lVar.setVisible(true);
            if (postWriteCallBackData != null) {
                BdToast.a(this.cIA.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), BdToast.DefaultIcon.SUCCESS).us();
            }
        } else if (postWriteCallBackData != null && nVar == null) {
            if (AntiHelper.or(postWriteCallBackData.getErrorCode())) {
                AntiHelper.X(this.cIA.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString());
            } else {
                BdToast.a(this.cIA.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString()).us();
            }
        }
    }
}
