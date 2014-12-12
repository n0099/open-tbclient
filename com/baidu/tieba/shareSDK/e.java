package com.baidu.tieba.shareSDK;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
class e implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ WriteShareActivity bNV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(WriteShareActivity writeShareActivity) {
        this.bNV = writeShareActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void onClick(com.baidu.tbadk.core.dialog.e eVar) {
        WriteData writeData;
        WriteShareActivity writeShareActivity = this.bNV;
        FrsActivityConfig frsActivityConfig = new FrsActivityConfig(this.bNV.getPageContext().getPageActivity());
        writeData = this.bNV.bNF;
        writeShareActivity.sendMessage(new CustomMessage(2003000, frsActivityConfig.createBackSpecialCfg(writeData.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
        eVar.dismiss();
        this.bNV.finish();
    }
}
