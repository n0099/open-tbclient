package com.baidu.tieba.write.shareSDK;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.write.view.e;
/* loaded from: classes.dex */
class c implements e.b {
    final /* synthetic */ WriteShareActivity fad;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(WriteShareActivity writeShareActivity) {
        this.fad = writeShareActivity;
    }

    @Override // com.baidu.tieba.write.view.e.b
    public void a(com.baidu.tieba.write.view.e eVar) {
        WriteData writeData;
        WriteShareActivity writeShareActivity = this.fad;
        FrsActivityConfig frsActivityConfig = new FrsActivityConfig(this.fad.getPageContext().getPageActivity());
        writeData = this.fad.evE;
        writeShareActivity.sendMessage(new CustomMessage((int) CmdConfigCustom.ACTIVITY_START_NORMAL, frsActivityConfig.createBackSpecialCfg(writeData.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
        eVar.dismiss();
        this.fad.finish();
    }
}
