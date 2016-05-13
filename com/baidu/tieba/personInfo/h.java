package com.baidu.tieba.personInfo;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.newFriends.ResponseDeleteFriendMessage;
import com.baidu.tieba.t;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ f this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(f fVar, int i) {
        super(i);
        this.this$0 = fVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        bj bjVar;
        bj bjVar2;
        if (socketResponsedMessage != null && (socketResponsedMessage instanceof ResponseDeleteFriendMessage)) {
            ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
            int error = responseDeleteFriendMessage.getError();
            String errorString = responseDeleteFriendMessage.getErrorString();
            if (error == 0) {
                bjVar = this.this$0.dFA;
                if (bjVar != null) {
                    bjVar2 = this.this$0.dFA;
                    bjVar2.aiL();
                }
            } else {
                errorString = StringUtils.isNull(responseDeleteFriendMessage.getErrorString()) ? this.this$0.getResources().getString(t.j.neterror) : responseDeleteFriendMessage.getErrorString();
            }
            this.this$0.showToast(errorString);
        }
    }
}
