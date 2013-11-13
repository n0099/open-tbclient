package com.baidu.tieba.pb;

import com.baidu.tieba.account.forbid.ForbidActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class al implements bt {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ NewPbActivity f2069a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public al(NewPbActivity newPbActivity) {
        this.f2069a = newPbActivity;
    }

    @Override // com.baidu.tieba.pb.bt
    public void a(Object obj) {
        com.baidu.tieba.model.bm bmVar;
        com.baidu.tieba.model.bm bmVar2;
        com.baidu.tieba.model.bm bmVar3;
        NewPbActivity newPbActivity = this.f2069a;
        bmVar = this.f2069a.s;
        String id = bmVar.l().c().getId();
        bmVar2 = this.f2069a.s;
        String name = bmVar2.l().c().getName();
        bmVar3 = this.f2069a.s;
        ForbidActivity.a(newPbActivity, id, name, bmVar3.l().d().a(), String.valueOf(obj));
    }
}
