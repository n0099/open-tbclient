package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.newFriends.RequestApplyMessage;
import com.baidu.tbadk.newFriends.ResponseApplyMessage;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
class q extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ PersonInfoActivity cue;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q(PersonInfoActivity personInfoActivity, int i) {
        super(i);
        this.cue = personInfoActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        y yVar;
        aj ajVar;
        if (socketResponsedMessage instanceof ResponseApplyMessage) {
            ResponseApplyMessage responseApplyMessage = (ResponseApplyMessage) socketResponsedMessage;
            if (responseApplyMessage.getError() != 0) {
                this.cue.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? this.cue.getResources().getString(i.h.neterror) : socketResponsedMessage.getErrorString());
                return;
            }
            RequestApplyMessage requestApplyMessage = (RequestApplyMessage) responseApplyMessage.getOrginalMessage();
            ReplyInfo replyInfo = new ReplyInfo();
            replyInfo.setUserId(requestApplyMessage.getUid());
            replyInfo.setFriendId(requestApplyMessage.getFriendId());
            replyInfo.setMessage(requestApplyMessage.getMessage());
            yVar = this.cue.ctR;
            yVar.akp().getReplyInfo().add(replyInfo);
            ajVar = this.cue.ctS;
            ajVar.akC();
        }
    }
}
