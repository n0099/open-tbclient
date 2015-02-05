package com.baidu.tieba.service;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends HttpMessageListener {
    final /* synthetic */ g bOW;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(g gVar, int i) {
        super(i);
        this.bOW = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage)) {
            com.baidu.tbadk.data.e msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData();
            if (!com.baidu.tbadk.coreExtra.messageCenter.a.rU() && msgData != null && TbadkApplication.getInst().isMsgRemindOn()) {
                if (msgData.uD() >= 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.rS().setMsgBookmark(msgData.uD());
                }
                if (msgData.uB() >= 0 && TbadkApplication.getInst().isMsgAtmeOn()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.rS().setMsgAtme(msgData.uB());
                }
                if (msgData.uA() >= 0 && TbadkApplication.getInst().isMsgReplymeOn()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.rS().setMsgReplyme(msgData.uA());
                }
                if (msgData.uC() >= 0 && TbadkApplication.getInst().isMsgNewFansOn()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.rS().setMsgFans(msgData.uC());
                }
            }
        }
    }
}
