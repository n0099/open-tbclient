package com.baidu.tieba.write;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.plugins.MotuPlugin;
/* loaded from: classes.dex */
class bq implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ bn a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bq(bn bnVar) {
        this.a = bnVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteImageActivity writeImageActivity;
        MessageManager messageManager = MessageManager.getInstance();
        writeImageActivity = this.a.a;
        messageManager.sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.bd(writeImageActivity, com.baidu.tbadk.tbplugin.m.a().d(MotuPlugin.class))));
    }
}
