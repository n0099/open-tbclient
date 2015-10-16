package com.baidu.tieba.mention;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aq implements a.d {
    final /* synthetic */ al caZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(al alVar) {
        this.caZ = alVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.l lVar, WriteData writeData, AntiData antiData) {
        SingleMentionActivity singleMentionActivity;
        com.baidu.tbadk.editortools.c.n nVar;
        SingleMentionActivity singleMentionActivity2;
        singleMentionActivity = this.caZ.caL;
        singleMentionActivity.hideProgressBar();
        nVar = this.caZ.caU;
        nVar.Ax().hide();
        if (postWriteCallBackData != null && lVar == null && !AntiHelper.lc(postWriteCallBackData.getErrorCode())) {
            singleMentionActivity2 = this.caZ.caL;
            singleMentionActivity2.showToast(postWriteCallBackData.getErrorString());
        }
    }
}
