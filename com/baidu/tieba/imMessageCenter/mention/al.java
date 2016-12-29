package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al extends HttpMessageListener {
    final /* synthetic */ ak dcL;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public al(ak akVar, int i) {
        super(i);
        this.dcL = akVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage)) {
            aj msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData();
            if (!com.baidu.tbadk.coreExtra.messageCenter.a.yA() && msgData != null && com.baidu.tbadk.coreExtra.messageCenter.c.yV().yX()) {
                if (msgData.auP() >= 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yy().setMsgBookmark(msgData.auP());
                }
                if (msgData.auN() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.yV().za()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yy().setMsgAtme(msgData.auN());
                }
                if (msgData.auM() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.yV().zc()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yy().setMsgReplyme(msgData.auM());
                }
                if (msgData.auO() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.yV().zb()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yy().setMsgFans(msgData.auO());
                }
            }
        }
    }
}
