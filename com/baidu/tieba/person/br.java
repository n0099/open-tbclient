package com.baidu.tieba.person;

import com.baidu.adp.framework.message.SocketResponsedMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class br extends com.baidu.adp.framework.c.g {
    final /* synthetic */ bn a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public br(bn bnVar, int i) {
        super(2001124);
        this.a = bnVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(SocketResponsedMessage socketResponsedMessage) {
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        if (socketResponsedMessage2 == null || socketResponsedMessage2.g() != 2001124) {
            return;
        }
        bn.a(this.a, socketResponsedMessage2);
    }
}
