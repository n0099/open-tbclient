package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj extends HttpMessageListener {
    final /* synthetic */ ai def;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(ai aiVar, int i) {
        super(i);
        this.def = aiVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage)) {
            ah msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData();
            if (!com.baidu.tbadk.coreExtra.messageCenter.a.xp() && msgData != null && com.baidu.tbadk.coreExtra.messageCenter.c.xK().xM()) {
                if (msgData.atC() >= 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.xn().setMsgBookmark(msgData.atC());
                }
                if (msgData.atA() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.xK().xP()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.xn().setMsgAtme(msgData.atA());
                }
                if (msgData.atz() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.xK().xR()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.xn().setMsgReplyme(msgData.atz());
                }
                if (msgData.atB() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.xK().xQ()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.xn().setMsgFans(msgData.atB());
                }
            }
        }
    }
}
