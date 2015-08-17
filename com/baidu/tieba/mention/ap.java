package com.baidu.tieba.mention;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements a.d {
    final /* synthetic */ ak bWv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ak akVar) {
        this.bWv = akVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.l lVar, WriteData writeData, AntiData antiData) {
        SingleMentionActivity singleMentionActivity;
        com.baidu.tbadk.editortools.c.n nVar;
        SingleMentionActivity singleMentionActivity2;
        singleMentionActivity = this.bWv.bWg;
        singleMentionActivity.hideProgressBar();
        nVar = this.bWv.bWp;
        nVar.Ay().hide();
        if (postWriteCallBackData != null && lVar == null) {
            singleMentionActivity2 = this.bWv.bWg;
            singleMentionActivity2.showToast(postWriteCallBackData.getErrorString());
        }
    }
}
