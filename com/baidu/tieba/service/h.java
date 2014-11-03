package com.baidu.tieba.service;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tieba.data.ac;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends HttpMessageListener {
    final /* synthetic */ g bJa;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(g gVar, int i) {
        super(i);
        this.bJa = gVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(HttpResponsedMessage httpResponsedMessage) {
        if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1002500 && (httpResponsedMessage instanceof MsgReminderHttpRespMessage)) {
            ac msgData = ((MsgReminderHttpRespMessage) httpResponsedMessage).getMsgData();
            if (!com.baidu.tbadk.coreExtra.messageCenter.a.oF() && msgData != null && TbadkApplication.m251getInst().isMsgRemindOn()) {
                if (msgData.zF() >= 0) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.oD().setMsgBookmark(msgData.zF());
                }
                if (msgData.zD() >= 0 && TbadkApplication.m251getInst().isMsgAtmeOn()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.oD().setMsgAtme(msgData.zD());
                }
                if (msgData.zC() >= 0 && TbadkApplication.m251getInst().isMsgReplymeOn()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.oD().setMsgReplyme(msgData.zC());
                }
                if (msgData.zE() >= 0 && TbadkApplication.m251getInst().isMsgNewFansOn()) {
                    com.baidu.tbadk.coreExtra.messageCenter.a.oD().setMsgFans(msgData.zE());
                }
            }
        }
    }
}
