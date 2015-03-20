package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.newFriends.ResponseDeleteFriendMessage;
/* loaded from: classes.dex */
class i extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ PersonInfoActivity bSh;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(PersonInfoActivity personInfoActivity, int i) {
        super(i);
        this.bSh = personInfoActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        ae aeVar;
        if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseDeleteFriendMessage)) {
            ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
            int error = responseDeleteFriendMessage.getError();
            String errorString = responseDeleteFriendMessage.getErrorString();
            if (error == 0) {
                aeVar = this.bSh.bRX;
                aeVar.startLoad();
            } else {
                errorString = StringUtils.isNull(responseDeleteFriendMessage.getErrorString()) ? this.bSh.getResources().getString(com.baidu.tieba.y.neterror) : responseDeleteFriendMessage.getErrorString();
            }
            this.bSh.showToast(errorString);
        }
    }
}
