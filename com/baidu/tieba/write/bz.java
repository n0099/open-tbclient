package com.baidu.tieba.write;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PluginDetailActivityConfig;
/* loaded from: classes.dex */
class bz implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ bw cfH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(bw bwVar) {
        this.cfH = bwVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteImageActivity writeImageActivity;
        MessageManager messageManager = MessageManager.getInstance();
        writeImageActivity = this.cfH.this$0;
        messageManager.sendMessage(new CustomMessage(2002001, new PluginDetailActivityConfig(writeImageActivity.getPageContext().getPageActivity(), "com.baidu.tieba.pluginMotu")));
        aVar.dismiss();
    }
}
