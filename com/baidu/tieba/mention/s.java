package com.baidu.tieba.mention;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends HttpMessageListener {
    final /* synthetic */ r bDn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(r rVar, int i) {
        super(i);
        this.bDn = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage)) {
            com.baidu.tbadk.data.e msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData();
            if (!com.baidu.tbadk.coreExtra.messageCenter.a.vb() && msgData != null && com.baidu.tbadk.coreExtra.messageCenter.c.vw().vy()) {
                if (msgData.xZ() >= 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.uZ().setMsgBookmark(msgData.xZ());
                }
                if (msgData.xX() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.vw().vB()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.uZ().setMsgAtme(msgData.xX());
                }
                if (msgData.xW() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.vw().vD()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.uZ().setMsgReplyme(msgData.xW());
                }
                if (msgData.xY() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.vw().vC()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.uZ().setMsgFans(msgData.xY());
                }
            }
        }
    }
}
