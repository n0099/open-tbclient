package com.baidu.tieba.shareSDK;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
class d implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ WriteShareActivity bJF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(WriteShareActivity writeShareActivity) {
        this.bJF = writeShareActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void onClick(com.baidu.tbadk.core.dialog.e eVar) {
        WriteData writeData;
        WriteShareActivity writeShareActivity = this.bJF;
        FrsActivityConfig frsActivityConfig = new FrsActivityConfig(this.bJF);
        writeData = this.bJF.bpJ;
        writeShareActivity.sendMessage(new CustomMessage(2003000, frsActivityConfig.createBackSpecialCfg(writeData.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
        eVar.dismiss();
        this.bJF.finish();
    }
}
