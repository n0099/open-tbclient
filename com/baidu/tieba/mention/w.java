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
            if (!com.baidu.tbadk.coreExtra.messageCenter.a.wM() && msgData != null && com.baidu.tbadk.coreExtra.messageCenter.c.xh().xj()) {
                if (msgData.acY() >= 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.wK().setMsgBookmark(msgData.acY());
                }
                if (msgData.acW() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.xh().xm()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.wK().setMsgAtme(msgData.acW());
                }
                if (msgData.acV() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.xh().xo()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.wK().setMsgReplyme(msgData.acV());
                }
                if (msgData.acX() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.xh().xn()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.wK().setMsgFans(msgData.acX());
                }
            }
        }
    }
}
