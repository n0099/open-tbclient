package com.baidu.tieba.write.write;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.core.atomData.PluginDetailActivityConfig;
/* loaded from: classes.dex */
class cf implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ cc cDf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cf(cc ccVar) {
        this.cDf = ccVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteImageActivity writeImageActivity;
        MessageManager messageManager = MessageManager.getInstance();
        writeImageActivity = this.cDf.this$0;
        messageManager.sendMessage(new CustomMessage(2002001, new PluginDetailActivityConfig(writeImageActivity.getPageContext().getPageActivity(), PluginCenter.NAME_MOTUSDK)));
        aVar.dismiss();
    }
}
