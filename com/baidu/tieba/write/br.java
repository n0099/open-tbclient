package com.baidu.tieba.write;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
/* loaded from: classes.dex */
class br implements com.baidu.tbadk.core.dialog.d {
    final /* synthetic */ bo a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(bo boVar) {
        this.a = boVar;
    }

    @Override // com.baidu.tbadk.core.dialog.d
    public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
        WriteImageActivity writeImageActivity;
        MessageManager messageManager = MessageManager.getInstance();
        writeImageActivity = this.a.a;
        messageManager.sendMessage(new CustomMessage(2002001, new com.baidu.tbadk.core.atomData.bk(writeImageActivity, "motu")));
    }
}
