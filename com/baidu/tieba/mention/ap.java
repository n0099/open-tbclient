package com.baidu.tieba.mention;

import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tbadkCore.writeModel.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ap implements a.d {
    final /* synthetic */ ak bXb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(ak akVar) {
        this.bXb = akVar;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.a.d
    public void a(boolean z, PostWriteCallBackData postWriteCallBackData, com.baidu.tbadk.coreExtra.data.l lVar, WriteData writeData, AntiData antiData) {
        SingleMentionActivity singleMentionActivity;
        com.baidu.tbadk.editortools.c.n nVar;
        SingleMentionActivity singleMentionActivity2;
        singleMentionActivity = this.bXb.bWM;
        singleMentionActivity.hideProgressBar();
        nVar = this.bXb.bWV;
        nVar.AL().hide();
        if (postWriteCallBackData != null && lVar == null) {
            singleMentionActivity2 = this.bXb.bWM;
            singleMentionActivity2.showToast(postWriteCallBackData.getErrorString());
        }
    }
}
