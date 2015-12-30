package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah extends HttpMessageListener {
    final /* synthetic */ ag ciI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ah(ag agVar, int i) {
        super(i);
        this.ciI = agVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage)) {
            af msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData();
            if (!com.baidu.tbadk.coreExtra.messageCenter.a.xx() && msgData != null && com.baidu.tbadk.coreExtra.messageCenter.c.xS().xU()) {
                if (msgData.aeD() >= 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.xv().setMsgBookmark(msgData.aeD());
                }
                if (msgData.aeB() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.xS().xX()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.xv().setMsgAtme(msgData.aeB());
                }
                if (msgData.aeA() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.xS().xZ()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.xv().setMsgReplyme(msgData.aeA());
                }
                if (msgData.aeC() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.xS().xY()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.xv().setMsgFans(msgData.aeC());
                }
            }
        }
    }
}
