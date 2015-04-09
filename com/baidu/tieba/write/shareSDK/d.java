package com.baidu.tieba.write.shareSDK;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
class d implements com.baidu.tieba.write.view.i {
    final /* synthetic */ WriteShareActivity cwd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(WriteShareActivity writeShareActivity) {
        this.cwd = writeShareActivity;
    }

    @Override // com.baidu.tieba.write.view.i
    public void onClick(com.baidu.tieba.write.view.f fVar) {
        WriteData writeData;
        WriteShareActivity writeShareActivity = this.cwd;
        FrsActivityConfig frsActivityConfig = new FrsActivityConfig(this.cwd.getPageContext().getPageActivity());
        writeData = this.cwd.cqk;
        writeShareActivity.sendMessage(new CustomMessage(2003000, frsActivityConfig.createBackSpecialCfg(writeData.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
        fVar.dismiss();
        this.cwd.finish();
    }
}
