package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj extends HttpMessageListener {
    final /* synthetic */ ai duf;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(ai aiVar, int i) {
        super(i);
        this.duf = aiVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage)) {
            ah msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData();
            if (!com.baidu.tbadk.coreExtra.messageCenter.a.yF() && msgData != null && com.baidu.tbadk.coreExtra.messageCenter.c.za().zc()) {
                if (msgData.azA() >= 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yD().setMsgBookmark(msgData.azA());
                }
                if (msgData.azy() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.za().zf()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yD().setMsgAtme(msgData.azy());
                }
                if (msgData.azx() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.za().zh()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yD().setMsgReplyme(msgData.azx());
                }
                if (msgData.azz() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.za().zg()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yD().setMsgFans(msgData.azz());
                }
            }
        }
    }
}
