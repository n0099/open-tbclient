package com.baidu.tieba.service;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends HttpMessageListener {
    final /* synthetic */ g bOX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(g gVar, int i) {
        super(i);
        this.bOX = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage)) {
            com.baidu.tbadk.data.e msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData();
            if (!com.baidu.tbadk.coreExtra.messageCenter.a.sa() && msgData != null && TbadkApplication.getInst().isMsgRemindOn()) {
                if (msgData.uJ() >= 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.rY().setMsgBookmark(msgData.uJ());
                }
                if (msgData.uH() >= 0 && TbadkApplication.getInst().isMsgAtmeOn()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.rY().setMsgAtme(msgData.uH());
                }
                if (msgData.uG() >= 0 && TbadkApplication.getInst().isMsgReplymeOn()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.rY().setMsgReplyme(msgData.uG());
                }
                if (msgData.uI() >= 0 && TbadkApplication.getInst().isMsgNewFansOn()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.rY().setMsgFans(msgData.uI());
                }
            }
        }
    }
}
