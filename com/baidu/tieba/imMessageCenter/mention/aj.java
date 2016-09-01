package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aj extends HttpMessageListener {
    final /* synthetic */ ai dsI;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj(ai aiVar, int i) {
        super(i);
        this.dsI = aiVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage)) {
            ah msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData();
            if (!com.baidu.tbadk.coreExtra.messageCenter.a.yC() && msgData != null && com.baidu.tbadk.coreExtra.messageCenter.c.yX().yZ()) {
                if (msgData.azc() >= 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yA().setMsgBookmark(msgData.azc());
                }
                if (msgData.aza() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.yX().zc()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yA().setMsgAtme(msgData.aza());
                }
                if (msgData.ayZ() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.yX().ze()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yA().setMsgReplyme(msgData.ayZ());
                }
                if (msgData.azb() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.yX().zd()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yA().setMsgFans(msgData.azb());
                }
            }
        }
    }
}
