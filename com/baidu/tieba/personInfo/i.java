package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.newFriends.ResponseDeleteFriendMessage;
/* loaded from: classes.dex */
class i extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ PersonInfoActivity bVe;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(PersonInfoActivity personInfoActivity, int i) {
        super(i);
        this.bVe = personInfoActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        ad adVar;
        if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseDeleteFriendMessage)) {
            ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
            int error = responseDeleteFriendMessage.getError();
            String errorString = responseDeleteFriendMessage.getErrorString();
            if (error == 0) {
                adVar = this.bVe.bUU;
                adVar.startLoad();
            } else {
                errorString = StringUtils.isNull(responseDeleteFriendMessage.getErrorString()) ? this.bVe.getResources().getString(com.baidu.tieba.t.neterror) : responseDeleteFriendMessage.getErrorString();
            }
            this.bVe.showToast(errorString);
        }
    }
}
