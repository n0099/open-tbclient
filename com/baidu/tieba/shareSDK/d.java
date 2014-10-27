package com.baidu.tieba.shareSDK;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
class d implements com.baidu.tbadk.core.dialog.h {
    final /* synthetic */ WriteShareActivity bJq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(WriteShareActivity writeShareActivity) {
        this.bJq = writeShareActivity;
    }

    @Override // com.baidu.tbadk.core.dialog.h
    public void onClick(com.baidu.tbadk.core.dialog.e eVar) {
        WriteData writeData;
        WriteShareActivity writeShareActivity = this.bJq;
        FrsActivityConfig frsActivityConfig = new FrsActivityConfig(this.bJq);
        writeData = this.bJq.bpv;
        writeShareActivity.sendMessage(new CustomMessage(2003000, frsActivityConfig.createNormalCfg(writeData.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE)));
        eVar.dismiss();
        this.bJq.finish();
    }
}
