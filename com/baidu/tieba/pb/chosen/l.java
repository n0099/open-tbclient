package com.baidu.tieba.pb.chosen;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* loaded from: classes.dex */
class l implements a.d {
    final /* synthetic */ PbChosenActivity bZS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PbChosenActivity pbChosenActivity) {
        this.bZS = pbChosenActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.l lVar, WriteData writeData, AntiData antiData) {
        com.baidu.tbadk.editortools.c.d dVar;
        com.baidu.tieba.pb.chosen.a.m mVar;
        this.bZS.hideProgressBar();
        if (z) {
            dVar = this.bZS.aTv;
            dVar.AL().hide();
            mVar = this.bZS.bZz;
            mVar.setVisible(true);
            if (postWriteCallBackData != null) {
                BdToast.a(this.bZS.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString(), BdToast.DefaultIcon.SUCCESS).tc();
            }
        } else if (postWriteCallBackData != null && lVar == null) {
            BdToast.b(this.bZS.getPageContext().getPageActivity(), postWriteCallBackData.getErrorString()).tc();
        }
    }
}
