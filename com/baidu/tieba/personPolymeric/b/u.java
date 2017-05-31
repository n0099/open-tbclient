package com.baidu.tieba.personPolymeric.b;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.newFriends.ResponseApplyMessage;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class u extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ p eLo;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(p pVar, int i) {
        super(i);
        this.eLo = pVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if ((socketResponsedMessage instanceof ResponseApplyMessage) && ((ResponseApplyMessage) socketResponsedMessage).getError() != 0) {
            this.eLo.ajh.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? this.eLo.ajh.getResources().getString(w.l.neterror) : socketResponsedMessage.getErrorString());
        }
    }
}
