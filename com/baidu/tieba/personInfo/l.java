package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.newFriends.RequestApplyMessage;
import com.baidu.tbadk.newFriends.ResponseApplyMessage;
/* loaded from: classes.dex */
class l extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ PersonInfoActivity bER;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public l(PersonInfoActivity personInfoActivity, int i) {
        super(i);
        this.bER = personInfoActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        v vVar;
        ae aeVar;
        if (socketResponsedMessage instanceof ResponseApplyMessage) {
            ResponseApplyMessage responseApplyMessage = (ResponseApplyMessage) socketResponsedMessage;
            int error = responseApplyMessage.getError();
            String errorString = responseApplyMessage.getErrorString();
            if (error != 0) {
                this.bER.showToast(errorString);
                return;
            }
            RequestApplyMessage requestApplyMessage = (RequestApplyMessage) responseApplyMessage.getOrginalMessage();
            ReplyInfo replyInfo = new ReplyInfo();
            replyInfo.setUserId(requestApplyMessage.getUid());
            replyInfo.setFriendId(requestApplyMessage.getFriendId());
            replyInfo.setMessage(requestApplyMessage.getMessage());
            vVar = this.bER.bEG;
            vVar.aaV().getReplyInfo().add(replyInfo);
            aeVar = this.bER.bEH;
            aeVar.abh();
        }
    }
}
