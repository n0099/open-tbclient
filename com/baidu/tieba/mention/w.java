package com.baidu.tieba.mention;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends HttpMessageListener {
    final /* synthetic */ v caF;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(v vVar, int i) {
        super(i);
        this.caF = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage)) {
            u msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData();
            if (!com.baidu.tbadk.coreExtra.messageCenter.a.wJ() && msgData != null && com.baidu.tbadk.coreExtra.messageCenter.c.xe().xg()) {
                if (msgData.acU() >= 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.wH().setMsgBookmark(msgData.acU());
                }
                if (msgData.acS() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.xe().xj()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.wH().setMsgAtme(msgData.acS());
                }
                if (msgData.acR() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.xe().xl()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.wH().setMsgReplyme(msgData.acR());
                }
                if (msgData.acT() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.xe().xk()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.wH().setMsgFans(msgData.acT());
                }
            }
        }
    }
}
