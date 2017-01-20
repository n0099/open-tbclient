package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bb implements NewWriteModel.d {
    final /* synthetic */ au dky;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(au auVar) {
        this.dky = auVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.q qVar, WriteData writeData, AntiData antiData) {
        ReplyMessageActivity replyMessageActivity;
        com.baidu.tbadk.editortools.pb.n nVar;
        ReplyMessageActivity replyMessageActivity2;
        replyMessageActivity = this.dky.dkg;
        replyMessageActivity.hideProgressBar();
        nVar = this.dky.dkr;
        nVar.Cw().hide();
        if (postWriteCallBackData != null && qVar == null && !AntiHelper.sa(postWriteCallBackData.getErrorCode())) {
            replyMessageActivity2 = this.dky.dkg;
            replyMessageActivity2.showToast(postWriteCallBackData.getErrorString());
        }
    }
}
