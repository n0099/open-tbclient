package com.baidu.tieba.person;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.newFriends.RequestApplyMessage;
import com.baidu.tbadk.newFriends.ResponseApplyMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class da extends com.baidu.adp.framework.listener.d {
    final /* synthetic */ ct a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public da(ct ctVar, int i) {
        super(i);
        this.a = ctVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        com.baidu.tieba.model.av avVar;
        bd bdVar;
        com.baidu.tieba.model.av avVar2;
        if (socketResponsedMessage instanceof ResponseApplyMessage) {
            ResponseApplyMessage responseApplyMessage = (ResponseApplyMessage) socketResponsedMessage;
            int error = responseApplyMessage.getError();
            String errorString = responseApplyMessage.getErrorString();
            if (error != 0) {
                this.a.b(errorString);
                return;
            }
            RequestApplyMessage requestApplyMessage = (RequestApplyMessage) responseApplyMessage.getOrginalMessage();
            cb cbVar = new cb();
            cbVar.a = requestApplyMessage.getUid();
            cbVar.b = requestApplyMessage.getFriendId();
            cbVar.c = requestApplyMessage.getMessage();
            avVar = this.a.e;
            avVar.a().h().add(cbVar);
            bdVar = this.a.l;
            avVar2 = this.a.e;
            bdVar.a(avVar2);
        }
    }
}
