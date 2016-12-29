package com.baidu.tieba.personPolymeric.b;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.newFriends.ResponseDeleteFriendMessage;
import com.baidu.tieba.r;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ h ety;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(h hVar, int i) {
        super(i);
        this.ety = hVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        TbPageContext tbPageContext;
        TbPageContext tbPageContext2;
        if (socketResponsedMessage instanceof ResponseDeleteFriendMessage) {
            ResponseDeleteFriendMessage responseDeleteFriendMessage = (ResponseDeleteFriendMessage) socketResponsedMessage;
            int error = responseDeleteFriendMessage.getError();
            String errorString = responseDeleteFriendMessage.getErrorString();
            if (error != 0) {
                if (StringUtils.isNull(responseDeleteFriendMessage.getErrorString())) {
                    tbPageContext = this.ety.GO;
                    errorString = tbPageContext.getResources().getString(r.j.neterror);
                } else {
                    errorString = responseDeleteFriendMessage.getErrorString();
                }
            } else {
                this.ety.jc(false);
            }
            tbPageContext2 = this.ety.GO;
            tbPageContext2.showToast(errorString);
        }
    }
}
