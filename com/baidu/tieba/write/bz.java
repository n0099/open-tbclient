package com.baidu.tieba.write;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.PluginDetailActivityConfig;
import com.baidu.tbadk.pluginArch.PluginNameList;
/* loaded from: classes.dex */
class bz implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ bw bUj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bz(bw bwVar) {
        this.bUj = bwVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteImageActivity writeImageActivity;
        MessageManager messageManager = MessageManager.getInstance();
        writeImageActivity = this.bUj.this$0;
        messageManager.sendMessage(new CustomMessage(2002001, new PluginDetailActivityConfig(writeImageActivity, PluginNameList.NAME_MOTUSDK)));
        aVar.dismiss();
    }
}
