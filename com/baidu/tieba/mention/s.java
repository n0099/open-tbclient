package com.baidu.tieba.mention;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s extends HttpMessageListener {
    final /* synthetic */ r bGi;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s(r rVar, int i) {
        super(i);
        this.bGi = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage)) {
            com.baidu.tbadk.data.e msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData();
            if (!com.baidu.tbadk.coreExtra.messageCenter.a.vL() && msgData != null && com.baidu.tbadk.coreExtra.messageCenter.c.wg().wi()) {
                if (msgData.yM() >= 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.vJ().setMsgBookmark(msgData.yM());
                }
                if (msgData.yK() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.wg().wl()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.vJ().setMsgAtme(msgData.yK());
                }
                if (msgData.yJ() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.wg().wn()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.vJ().setMsgReplyme(msgData.yJ());
                }
                if (msgData.yL() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.wg().wm()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.vJ().setMsgFans(msgData.yL());
                }
            }
        }
    }
}
