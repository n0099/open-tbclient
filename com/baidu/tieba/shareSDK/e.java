package com.baidu.tieba.shareSDK;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
class e implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ WriteShareActivity bPF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(WriteShareActivity writeShareActivity) {
        this.bPF = writeShareActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void onClick(com.baidu.tbadk.core.dialog.e eVar) {
        WriteData writeData;
        WriteShareActivity writeShareActivity = this.bPF;
        FrsActivityConfig frsActivityConfig = new FrsActivityConfig(this.bPF.getPageContext().getPageActivity());
        writeData = this.bPF.bPp;
        writeShareActivity.sendMessage(new CustomMessage(2003000, frsActivityConfig.createBackSpecialCfg(writeData.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
        eVar.dismiss();
        this.bPF.finish();
    }
}
