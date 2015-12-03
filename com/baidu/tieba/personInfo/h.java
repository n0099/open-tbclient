package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.newFriends.RequestApplyMessage;
import com.baidu.tbadk.newFriends.ResponseApplyMessage;
import com.baidu.tieba.n;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ d cSn;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(d dVar, int i) {
        super(i);
        this.cSn = dVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        aw awVar;
        az azVar;
        az azVar2;
        String errorString;
        if (socketResponsedMessage instanceof ResponseApplyMessage) {
            ResponseApplyMessage responseApplyMessage = (ResponseApplyMessage) socketResponsedMessage;
            if (responseApplyMessage.getError() != 0) {
                if (StringUtils.isNull(socketResponsedMessage.getErrorString())) {
                    errorString = this.cSn.getResources().getString(n.i.neterror);
                } else {
                    errorString = socketResponsedMessage.getErrorString();
                }
                this.cSn.showToast(errorString);
                return;
            }
            RequestApplyMessage requestApplyMessage = (RequestApplyMessage) responseApplyMessage.getOrginalMessage();
            ReplyInfo replyInfo = new ReplyInfo();
            replyInfo.setUserId(requestApplyMessage.getUid());
            replyInfo.setFriendId(requestApplyMessage.getFriendId());
            replyInfo.setMessage(requestApplyMessage.getMessage());
            awVar = this.cSn.cMT;
            awVar.apc().getReplyInfo().add(replyInfo);
            azVar = this.cSn.cRH;
            if (azVar != null) {
                azVar2 = this.cSn.cRH;
                azVar2.apB();
            }
        }
    }
}
