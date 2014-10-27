package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.newFriends.ResponseDeleteFriendMessage;
/* loaded from: classes.dex */
class i extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ PersonInfoActivity bED;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(PersonInfoActivity personInfoActivity, int i) {
        super(i);
        this.bED = personInfoActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        v vVar;
        v vVar2;
        ae aeVar;
        if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseDeleteFriendMessage)) {
            ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
            int error = responseDeleteFriendMessage.getError();
            this.bED.showToast(responseDeleteFriendMessage.getErrorString());
            if (error == 0) {
                vVar = this.bED.bEs;
                if (vVar.aaS() != null) {
                    vVar2 = this.bED.bEs;
                    vVar2.aaS().setIsFriend(0);
                    aeVar = this.bED.bEt;
                    aeVar.abe();
                }
            }
        }
    }
}
