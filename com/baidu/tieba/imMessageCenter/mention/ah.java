package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ah extends HttpMessageListener {
    final /* synthetic */ ag cni;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ah(ag agVar, int i) {
        super(i);
        this.cni = agVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage)) {
            af msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData();
            if (!com.baidu.tbadk.coreExtra.messageCenter.a.yP() && msgData != null && com.baidu.tbadk.coreExtra.messageCenter.c.zk().zm()) {
                if (msgData.ahN() >= 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yN().setMsgBookmark(msgData.ahN());
                }
                if (msgData.ahL() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.zk().zp()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yN().setMsgAtme(msgData.ahL());
                }
                if (msgData.ahK() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.zk().zr()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yN().setMsgReplyme(msgData.ahK());
                }
                if (msgData.ahM() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.zk().zq()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.yN().setMsgFans(msgData.ahM());
                }
            }
        }
    }
}
