package com.baidu.tieba.person;

import com.baidu.adp.framework.message.SocketResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dc extends com.baidu.adp.framework.listener.d {
    final /* synthetic */ ct a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dc(ct ctVar, int i) {
        super(i);
        this.a = ctVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(SocketResponsedMessage socketResponsedMessage) {
        if (socketResponsedMessage == null || socketResponsedMessage.getCmd() != 2001124) {
            return;
        }
        this.a.a(socketResponsedMessage);
    }
}
