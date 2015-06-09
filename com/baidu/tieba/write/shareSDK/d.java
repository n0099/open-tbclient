package com.baidu.tieba.write.shareSDK;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
class d implements com.baidu.tieba.write.view.i {
    final /* synthetic */ WriteShareActivity cAu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(WriteShareActivity writeShareActivity) {
        this.cAu = writeShareActivity;
    }

    @Override // com.baidu.tieba.write.view.i
    public void a(com.baidu.tieba.write.view.f fVar) {
        WriteData writeData;
        WriteShareActivity writeShareActivity = this.cAu;
        FrsActivityConfig frsActivityConfig = new FrsActivityConfig(this.cAu.getPageContext().getPageActivity());
        writeData = this.cAu.cup;
        writeShareActivity.sendMessage(new CustomMessage(2003000, frsActivityConfig.createBackSpecialCfg(writeData.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
        fVar.dismiss();
        this.cAu.finish();
    }
}
