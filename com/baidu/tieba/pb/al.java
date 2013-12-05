package com.baidu.tieba.pb;

import com.baidu.tieba.account.forbid.ForbidActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements bv {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2159a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(NewPbActivity newPbActivity) {
        this.f2159a = newPbActivity;
    }

    @Override // com.baidu.tieba.pb.bv
    public void a(Object obj) {
        com.baidu.tieba.model.bm bmVar;
        com.baidu.tieba.model.bm bmVar2;
        com.baidu.tieba.model.bm bmVar3;
        com.baidu.tieba.model.bm bmVar4;
        bmVar = this.f2159a.s;
        String valueOf = String.valueOf(bmVar.l().h().getId());
        String valueOf2 = String.valueOf(((Object[]) obj)[1]);
        NewPbActivity newPbActivity = this.f2159a;
        bmVar2 = this.f2159a.s;
        String id = bmVar2.l().c().getId();
        bmVar3 = this.f2159a.s;
        String name = bmVar3.l().c().getName();
        bmVar4 = this.f2159a.s;
        ForbidActivity.a(newPbActivity, id, name, bmVar4.l().d().a(), valueOf, valueOf2);
    }
}
