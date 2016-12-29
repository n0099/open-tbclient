package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements b.d {
    final /* synthetic */ bb ddm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(bb bbVar) {
        this.ddm = bbVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.b.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.q qVar, WriteData writeData, AntiData antiData) {
        ReplyMessageActivity replyMessageActivity;
        com.baidu.tbadk.editortools.e.p pVar;
        ReplyMessageActivity replyMessageActivity2;
        replyMessageActivity = this.ddm.dcV;
        replyMessageActivity.hideProgressBar();
        pVar = this.ddm.ddg;
        pVar.CB().hide();
        if (postWriteCallBackData != null && qVar == null && !AntiHelper.rp(postWriteCallBackData.getErrorCode())) {
            replyMessageActivity2 = this.ddm.dcV;
            replyMessageActivity2.showToast(postWriteCallBackData.getErrorString());
        }
    }
}
