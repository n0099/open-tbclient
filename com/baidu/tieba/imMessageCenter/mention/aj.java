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
            if (!com.baidu.tbadk.coreExtra.messageCenter.a.xk() && msgData != null && com.baidu.tbadk.coreExtra.messageCenter.c.xF().xH()) {
                if (msgData.aln() >= 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.xi().setMsgBookmark(msgData.aln());
                }
                if (msgData.all() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.xF().xK()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.xi().setMsgAtme(msgData.all());
                }
                if (msgData.alk() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.xF().xM()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.xi().setMsgReplyme(msgData.alk());
                }
                if (msgData.alm() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.xF().xL()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.xi().setMsgFans(msgData.alm());
                }
            }
        }
    }
}
