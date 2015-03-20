package com.baidu.tieba.mention;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends HttpMessageListener {
    final /* synthetic */ r bDa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(r rVar, int i) {
        super(i);
        this.bDa = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage)) {
            com.baidu.tbadk.data.e msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData();
            if (!com.baidu.tbadk.coreExtra.messageCenter.a.uV() && msgData != null && com.baidu.tbadk.coreExtra.messageCenter.c.vq().vs()) {
                if (msgData.xT() >= 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.uT().setMsgBookmark(msgData.xT());
                }
                if (msgData.xR() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.vq().vv()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.uT().setMsgAtme(msgData.xR());
                }
                if (msgData.xQ() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.vq().vx()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.uT().setMsgReplyme(msgData.xQ());
                }
                if (msgData.xS() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.vq().vw()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.uT().setMsgFans(msgData.xS());
                }
            }
        }
    }
}
