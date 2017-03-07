package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai extends HttpMessageListener {
    final /* synthetic */ ah dmq;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ai(ah ahVar, int i) {
        super(i);
        this.dmq = ahVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage)) {
            ag msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData();
            if (!com.baidu.tbadk.coreExtra.messageCenter.a.yM() && msgData != null && com.baidu.tbadk.coreExtra.messageCenter.c.zh().zj()) {
                if (msgData.avr() >= 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yK().setMsgBookmark(msgData.avr());
                }
                if (msgData.avp() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.zh().zm()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yK().setMsgAtme(msgData.avp());
                }
                if (msgData.avo() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.zh().zo()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yK().setMsgReplyme(msgData.avo());
                }
                if (msgData.avq() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.zh().zn()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yK().setMsgFans(msgData.avq());
                }
            }
        }
    }
}
