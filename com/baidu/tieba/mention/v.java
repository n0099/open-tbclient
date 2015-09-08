package com.baidu.tieba.mention;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends HttpMessageListener {
    final /* synthetic */ u bWG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(u uVar, int i) {
        super(i);
        this.bWG = uVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage)) {
            com.baidu.tbadk.data.e msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData();
            if (!com.baidu.tbadk.coreExtra.messageCenter.a.xb() && msgData != null && com.baidu.tbadk.coreExtra.messageCenter.c.xw().xy()) {
                if (msgData.Ak() >= 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.wZ().setMsgBookmark(msgData.Ak());
                }
                if (msgData.Ai() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.xw().xB()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.wZ().setMsgAtme(msgData.Ai());
                }
                if (msgData.Ah() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.xw().xD()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.wZ().setMsgReplyme(msgData.Ah());
                }
                if (msgData.Aj() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.xw().xC()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.wZ().setMsgFans(msgData.Aj());
                }
            }
        }
    }
}
