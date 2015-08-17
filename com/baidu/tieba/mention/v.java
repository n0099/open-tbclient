package com.baidu.tieba.mention;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class v extends HttpMessageListener {
    final /* synthetic */ u bWa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public v(u uVar, int i) {
        super(i);
        this.bWa = uVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage)) {
            com.baidu.tbadk.data.e msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData();
            if (!com.baidu.tbadk.coreExtra.messageCenter.a.wV() && msgData != null && com.baidu.tbadk.coreExtra.messageCenter.c.xq().xs()) {
                if (msgData.zX() >= 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.wT().setMsgBookmark(msgData.zX());
                }
                if (msgData.zV() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.xq().xv()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.wT().setMsgAtme(msgData.zV());
                }
                if (msgData.zU() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.xq().xx()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.wT().setMsgReplyme(msgData.zU());
                }
                if (msgData.zW() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.xq().xw()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.wT().setMsgFans(msgData.zW());
                }
            }
        }
    }
}
