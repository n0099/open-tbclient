package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class aj extends HttpMessageListener {
    final /* synthetic */ ai dhl;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(ai aiVar, int i) {
        super(i);
        this.dhl = aiVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage)) {
            ah msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData();
            if (!com.baidu.tbadk.coreExtra.messageCenter.a.yw() && msgData != null && com.baidu.tbadk.coreExtra.messageCenter.c.yR().yT()) {
                if (msgData.atg() >= 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yu().setMsgBookmark(msgData.atg());
                }
                if (msgData.ate() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.yR().yW()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yu().setMsgAtme(msgData.ate());
                }
                if (msgData.atd() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.yR().yY()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yu().setMsgReplyme(msgData.atd());
                }
                if (msgData.atf() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.yR().yX()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yu().setMsgFans(msgData.atf());
                }
            }
        }
    }
}
