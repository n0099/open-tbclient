package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class bc implements NewWriteModel.d {
    final /* synthetic */ av dve;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(av avVar) {
        this.dve = avVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.q qVar, WriteData writeData, AntiData antiData) {
        ReplyMessageActivity replyMessageActivity;
        com.baidu.tbadk.editortools.pb.n nVar;
        ReplyMessageActivity replyMessageActivity2;
        replyMessageActivity = this.dve.duN;
        replyMessageActivity.hideProgressBar();
        nVar = this.dve.duY;
        nVar.CG().hide();
        if (postWriteCallBackData != null && qVar == null && !AntiHelper.sK(postWriteCallBackData.getErrorCode()) && postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278) {
            replyMessageActivity2 = this.dve.duN;
            replyMessageActivity2.showToast(postWriteCallBackData.getErrorString());
        }
    }
}
