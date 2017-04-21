package com.baidu.tieba.imMessageCenter.mention;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ai extends HttpMessageListener {
    final /* synthetic */ ah dng;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ai(ah ahVar, int i) {
        super(i);
        this.dng = ahVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage)) {
            ag msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData();
            if (!com.baidu.tbadk.coreExtra.messageCenter.a.zl() && msgData != null && com.baidu.tbadk.coreExtra.messageCenter.c.zG().zI()) {
                if (msgData.awl() >= 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.zj().setMsgBookmark(msgData.awl());
                }
                if (msgData.awj() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.zG().zL()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.zj().setMsgAtme(msgData.awj());
                }
                if (msgData.awi() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.zG().zN()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.zj().setMsgReplyme(msgData.awi());
                }
                if (msgData.awk() >= 0 && com.baidu.tbadk.coreExtra.messageCenter.c.zG().zM()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.zj().setMsgFans(msgData.awk());
                }
            }
        }
    }
}
