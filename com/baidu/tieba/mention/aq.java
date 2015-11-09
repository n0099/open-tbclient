package com.baidu.tieba.mention;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements a.d {
    final /* synthetic */ al cbA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(al alVar) {
        this.cbA = alVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.l lVar, WriteData writeData, AntiData antiData) {
        SingleMentionActivity singleMentionActivity;
        com.baidu.tbadk.editortools.c.p pVar;
        SingleMentionActivity singleMentionActivity2;
        singleMentionActivity = this.cbA.cbm;
        singleMentionActivity.hideProgressBar();
        pVar = this.cbA.cbv;
        pVar.Az().hide();
        if (postWriteCallBackData != null && lVar == null && !AntiHelper.lr(postWriteCallBackData.getErrorCode())) {
            singleMentionActivity2 = this.cbA.cbm;
            singleMentionActivity2.showToast(postWriteCallBackData.getErrorString());
        }
    }
}
