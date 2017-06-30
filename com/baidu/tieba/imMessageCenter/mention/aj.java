package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class aj extends HttpMessageListener {
    final /* synthetic */ ai duD;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(ai aiVar, int i) {
        super(i);
        this.duD = aiVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage)) {
            ah msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData();
            if (!com.baidu.tbadk.coreExtra.messageCenter.a.yI() && msgData != null && com.baidu.tbadk.coreExtra.messageCenter.c.zd().zf()) {
                if (msgData.axJ() >= 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yG().setMsgBookmark(msgData.axJ());
                }
                if (msgData.axH() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.zd().zi()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yG().setMsgAtme(msgData.axH());
                }
                if (msgData.axG() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.zd().zk()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yG().setMsgReplyme(msgData.axG());
                }
                if (msgData.axI() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.zd().zj()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yG().setMsgFans(msgData.axI());
                }
            }
        }
    }
}
