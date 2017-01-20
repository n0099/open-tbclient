package com.baidu.tieba.write.write;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.core.atomData.PluginDetailActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.write.write.WriteImageActivity;
/* loaded from: classes.dex */
class bv implements a.b {
    final /* synthetic */ WriteImageActivity.a fMy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bv(WriteImageActivity.a aVar) {
        this.fMy = aVar;
    }

    @Override // com.baidu.tbadk.core.dialog.a.b
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteImageActivity writeImageActivity;
        MessageManager messageManager = MessageManager.getInstance();
        writeImageActivity = WriteImageActivity.this;
        messageManager.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PluginDetailActivityConfig(writeImageActivity.getPageContext().getPageActivity(), PluginCenter.NAME_MOTUSDK)));
        aVar.dismiss();
    }
}
