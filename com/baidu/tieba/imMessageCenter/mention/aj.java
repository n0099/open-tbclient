package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj extends HttpMessageListener {
    final /* synthetic */ ai dzK;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(ai aiVar, int i) {
        super(i);
        this.dzK = aiVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage)) {
            ah msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData();
            if (!com.baidu.tbadk.coreExtra.messageCenter.a.yM() && msgData != null && com.baidu.tbadk.coreExtra.messageCenter.c.zh().zj()) {
                if (msgData.aBw() >= 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yK().setMsgBookmark(msgData.aBw());
                }
                if (msgData.aBu() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.zh().zm()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yK().setMsgAtme(msgData.aBu());
                }
                if (msgData.aBt() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.zh().zo()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yK().setMsgReplyme(msgData.aBt());
                }
                if (msgData.aBv() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.zh().zn()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yK().setMsgFans(msgData.aBv());
                }
            }
        }
    }
}
