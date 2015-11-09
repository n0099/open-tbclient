package com.baidu.tieba.mention;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class w extends HttpMessageListener {
    final /* synthetic */ v cbg;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(v vVar, int i) {
        super(i);
        this.cbg = vVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage)) {
            u msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData();
            if (!com.baidu.tbadk.coreExtra.messageCenter.a.wO() && msgData != null && com.baidu.tbadk.coreExtra.messageCenter.c.xj().xl()) {
                if (msgData.adp() >= 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.wM().setMsgBookmark(msgData.adp());
                }
                if (msgData.adn() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.xj().xo()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.wM().setMsgAtme(msgData.adn());
                }
                if (msgData.adm() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.xj().xq()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.wM().setMsgReplyme(msgData.adm());
                }
                if (msgData.ado() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.xj().xp()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.wM().setMsgFans(msgData.ado());
                }
            }
        }
    }
}
