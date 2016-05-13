package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj extends HttpMessageListener {
    final /* synthetic */ ai cyJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(ai aiVar, int i) {
        super(i);
        this.cyJ = aiVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage)) {
            ah msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData();
            if (!com.baidu.tbadk.coreExtra.messageCenter.a.xl() && msgData != null && com.baidu.tbadk.coreExtra.messageCenter.c.xG().xI()) {
                if (msgData.alp() >= 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.xj().setMsgBookmark(msgData.alp());
                }
                if (msgData.aln() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.xG().xL()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.xj().setMsgAtme(msgData.aln());
                }
                if (msgData.alm() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.xG().xN()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.xj().setMsgReplyme(msgData.alm());
                }
                if (msgData.alo() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.xG().xM()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.xj().setMsgFans(msgData.alo());
                }
            }
        }
    }
}
