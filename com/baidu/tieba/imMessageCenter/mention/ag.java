package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ag extends HttpMessageListener {
    final /* synthetic */ af ceG;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(af afVar, int i) {
        super(i);
        this.ceG = afVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage)) {
            ae msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData();
            if (!com.baidu.tbadk.coreExtra.messageCenter.a.xL() && msgData != null && com.baidu.tbadk.coreExtra.messageCenter.c.yg().yi()) {
                if (msgData.adv() >= 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.xJ().setMsgBookmark(msgData.adv());
                }
                if (msgData.adt() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.yg().yl()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.xJ().setMsgAtme(msgData.adt());
                }
                if (msgData.ads() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.yg().yn()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.xJ().setMsgReplyme(msgData.ads());
                }
                if (msgData.adu() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.yg().ym()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.xJ().setMsgFans(msgData.adu());
                }
            }
        }
    }
}
