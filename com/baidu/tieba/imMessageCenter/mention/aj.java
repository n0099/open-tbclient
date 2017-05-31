package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class aj extends HttpMessageListener {
    final /* synthetic */ ai dmH;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(ai aiVar, int i) {
        super(i);
        this.dmH = aiVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage)) {
            ah msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData();
            if (!com.baidu.tbadk.coreExtra.messageCenter.a.yp() && msgData != null && com.baidu.tbadk.coreExtra.messageCenter.c.yK().yM()) {
                if (msgData.aub() >= 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yn().setMsgBookmark(msgData.aub());
                }
                if (msgData.atZ() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.yK().yP()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yn().setMsgAtme(msgData.atZ());
                }
                if (msgData.atY() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.yK().yR()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yn().setMsgReplyme(msgData.atY());
                }
                if (msgData.aua() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.yK().yQ()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yn().setMsgFans(msgData.aua());
                }
            }
        }
    }
}
