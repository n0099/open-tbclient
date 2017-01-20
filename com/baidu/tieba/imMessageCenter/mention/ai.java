package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai extends HttpMessageListener {
    final /* synthetic */ ah djW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ai(ah ahVar, int i) {
        super(i);
        this.djW = ahVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage)) {
            ag msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData();
            if (!com.baidu.tbadk.coreExtra.messageCenter.a.yv() && msgData != null && com.baidu.tbadk.coreExtra.messageCenter.c.yQ().yS()) {
                if (msgData.avV() >= 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yt().setMsgBookmark(msgData.avV());
                }
                if (msgData.avT() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.yQ().yV()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yt().setMsgAtme(msgData.avT());
                }
                if (msgData.avS() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.yQ().yX()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yt().setMsgReplyme(msgData.avS());
                }
                if (msgData.avU() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.yQ().yW()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yt().setMsgFans(msgData.avU());
                }
            }
        }
    }
}
