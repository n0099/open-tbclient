package com.baidu.tieba.personPolymeric.b;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.newFriends.ResponseApplyMessage;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class w extends com.baidu.adp.framework.listener.e {
    final /* synthetic */ r eVs;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w(r rVar, int i) {
        super(i);
        this.eVs = rVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if ((socketResponsedMessage instanceof ResponseApplyMessage) && ((ResponseApplyMessage) socketResponsedMessage).getError() != 0) {
            this.eVs.ajP.showToast(StringUtils.isNull(socketResponsedMessage.getErrorString()) ? this.eVs.ajP.getResources().getString(w.l.neterror) : socketResponsedMessage.getErrorString());
        }
    }
}
