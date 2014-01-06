package com.baidu.tieba.pb;

import com.baidu.tieba.account.forbid.ForbidActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bw implements bx {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bw(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.tieba.pb.bx
    public void a(Object obj) {
        com.baidu.tieba.model.bm bmVar;
        com.baidu.tieba.model.bm bmVar2;
        com.baidu.tieba.model.bm bmVar3;
        com.baidu.tieba.model.bm bmVar4;
        bmVar = this.a.t;
        String valueOf = String.valueOf(bmVar.l().h().getId());
        String valueOf2 = String.valueOf(((Object[]) obj)[1]);
        NewPbActivity newPbActivity = this.a;
        bmVar2 = this.a.t;
        String id = bmVar2.l().c().getId();
        bmVar3 = this.a.t;
        String name = bmVar3.l().c().getName();
        bmVar4 = this.a.t;
        ForbidActivity.a(newPbActivity, id, name, bmVar4.l().d().a(), valueOf, valueOf2);
    }
}
