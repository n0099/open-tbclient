package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.newFriends.RequestApplyMessage;
import com.baidu.tbadk.newFriends.ResponseApplyMessage;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ h this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(h hVar, int i) {
        super(i);
        this.this$0 = hVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        bn bnVar;
        bq bqVar;
        bq bqVar2;
        if (socketResponsedMessage instanceof ResponseApplyMessage) {
            ResponseApplyMessage responseApplyMessage = (ResponseApplyMessage) socketResponsedMessage;
            if (responseApplyMessage.getError() != 0) {
                this.this$0.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? this.this$0.getResources().getString(u.j.neterror) : socketResponsedMessage.getErrorString());
                return;
            }
            RequestApplyMessage requestApplyMessage = (RequestApplyMessage) responseApplyMessage.getOrginalMessage();
            ReplyInfo replyInfo = new ReplyInfo();
            replyInfo.setUserId(requestApplyMessage.getUid());
            replyInfo.setFriendId(requestApplyMessage.getFriendId());
            replyInfo.setMessage(requestApplyMessage.getMessage());
            bnVar = this.this$0.ers;
            bnVar.aPD().getReplyInfo().add(replyInfo);
            bqVar = this.this$0.eAu;
            if (bqVar != null) {
                bqVar2 = this.this$0.eAu;
                bqVar2.aQj();
            }
        }
    }
}
