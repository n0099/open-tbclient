package com.baidu.tieba.person;

import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.tbadk.core.message.ResponseCheckUserMaskMessage;
import com.baidu.tbadk.core.message.ResponseUpdateMaskInfoMessage;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class bo extends com.baidu.adp.framework.c.g {
    final /* synthetic */ bn a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public bo(bn bnVar, int i) {
        super(0);
        this.a = bnVar;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.f] */
    @Override // com.baidu.adp.framework.c.c
    public final /* synthetic */ void a(SocketResponsedMessage socketResponsedMessage) {
        com.baidu.tieba.model.e eVar;
        ag agVar;
        boolean z;
        com.baidu.tieba.model.e eVar2;
        com.baidu.tieba.model.e eVar3;
        com.baidu.tbadk.core.e eVar4;
        ag agVar2;
        com.baidu.tbadk.core.dialog.d dVar;
        com.baidu.tbadk.core.dialog.d dVar2;
        com.baidu.tbadk.core.e eVar5;
        ag agVar3;
        com.baidu.tieba.model.e eVar6;
        SocketResponsedMessage socketResponsedMessage2 = socketResponsedMessage;
        if (socketResponsedMessage2 != null) {
            if (socketResponsedMessage2.g() == 104102 && (socketResponsedMessage2 instanceof ResponseUpdateMaskInfoMessage)) {
                ResponseUpdateMaskInfoMessage responseUpdateMaskInfoMessage = (ResponseUpdateMaskInfoMessage) socketResponsedMessage2;
                com.baidu.adp.framework.message.d<?> h = responseUpdateMaskInfoMessage.h();
                if (h == null || !(h instanceof com.baidu.tbadk.core.message.d)) {
                    return;
                }
                com.baidu.tbadk.core.message.d dVar3 = (com.baidu.tbadk.core.message.d) h;
                if (dVar3.i() != 10) {
                    return;
                }
                if (dVar3.j() == 1) {
                    eVar6 = this.a.d;
                    eVar6.b(1);
                } else {
                    eVar2 = this.a.d;
                    eVar2.b(0);
                }
                if (responseUpdateMaskInfoMessage.e() != 0) {
                    this.a.a(responseUpdateMaskInfoMessage.f());
                    return;
                }
                eVar3 = this.a.d;
                if (eVar3.a() == 1) {
                    bn bnVar = this.a;
                    eVar5 = this.a.f;
                    bnVar.a(eVar5.getString(com.baidu.tieba.a.k.black_list_added));
                    agVar3 = this.a.o;
                    agVar3.b(true);
                } else {
                    bn bnVar2 = this.a;
                    eVar4 = this.a.f;
                    bnVar2.a(eVar4.getString(com.baidu.tieba.a.k.black_list_remove_success));
                    agVar2 = this.a.o;
                    agVar2.b(false);
                }
                dVar = this.a.i;
                if (dVar != null) {
                    dVar2 = this.a.i;
                    dVar2.c();
                }
            } else if (socketResponsedMessage2.g() == 104104 && (socketResponsedMessage2 instanceof ResponseCheckUserMaskMessage)) {
                ResponseCheckUserMaskMessage responseCheckUserMaskMessage = (ResponseCheckUserMaskMessage) socketResponsedMessage2;
                eVar = this.a.d;
                eVar.b(responseCheckUserMaskMessage.d() ? 1 : 0);
                agVar = this.a.o;
                agVar.b(responseCheckUserMaskMessage.d());
                z = this.a.k;
                if (z) {
                    this.a.h();
                }
            }
        }
        this.a.k = false;
    }
}
