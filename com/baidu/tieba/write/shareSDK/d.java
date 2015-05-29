package com.baidu.tieba.write.shareSDK;

import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes.dex */
class d implements com.baidu.tieba.write.view.i {
    final /* synthetic */ WriteShareActivity cAt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(WriteShareActivity writeShareActivity) {
        this.cAt = writeShareActivity;
    }

    @Override // com.baidu.tieba.write.view.i
    public void a(com.baidu.tieba.write.view.f fVar) {
        WriteData writeData;
        WriteShareActivity writeShareActivity = this.cAt;
        FrsActivityConfig frsActivityConfig = new FrsActivityConfig(this.cAt.getPageContext().getPageActivity());
        writeData = this.cAt.cuo;
        writeShareActivity.sendMessage(new CustomMessage(2003000, frsActivityConfig.createBackSpecialCfg(writeData.getForumName(), FrsActivityConfig.FRS_FROM_WRITESHARE, true, false)));
        fVar.dismiss();
        this.cAt.finish();
    }
}
