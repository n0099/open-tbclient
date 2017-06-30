package com.baidu.tieba.personPolymeric.b;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.newFriends.ResponseDeleteFriendMessage;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ r eVs;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t(r rVar, int i) {
        super(i);
        this.eVs = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage instanceof ResponseDeleteFriendMessage) {
            ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
            int error = responseDeleteFriendMessage.getError();
            String errorString = responseDeleteFriendMessage.getErrorString();
            if (error != 0) {
                errorString = StringUtils.isNull(responseDeleteFriendMessage.getErrorString()) ? this.eVs.ajP.getResources().getString(w.l.neterror) : responseDeleteFriendMessage.getErrorString();
            } else {
                this.eVs.jU(false);
            }
            this.eVs.ajP.showToast(errorString);
        }
    }
}
