package com.baidu.tieba.service;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends HttpMessageListener {
    final /* synthetic */ g bNn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(g gVar, int i) {
        super(i);
        this.bNn = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage)) {
            com.baidu.tbadk.data.e msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData();
            if (!com.baidu.tbadk.coreExtra.messageCenter.a.rK() && msgData != null && TbadkApplication.getInst().isMsgRemindOn()) {
                if (msgData.us() >= 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.rI().setMsgBookmark(msgData.us());
                }
                if (msgData.uq() >= 0 && TbadkApplication.getInst().isMsgAtmeOn()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.rI().setMsgAtme(msgData.uq());
                }
                if (msgData.up() >= 0 && TbadkApplication.getInst().isMsgReplymeOn()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.rI().setMsgReplyme(msgData.up());
                }
                if (msgData.ur() >= 0 && TbadkApplication.getInst().isMsgNewFansOn()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.rI().setMsgFans(msgData.ur());
                }
            }
        }
    }
}
