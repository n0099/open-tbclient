package com.baidu.tieba.pb;

import com.baidu.tieba.account.forbid.ForbidActivity;
/* loaded from: classes.dex */
final class bk implements cb {
    final /* synthetic */ NewPbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(NewPbActivity newPbActivity) {
        this.a = newPbActivity;
    }

    @Override // com.baidu.tieba.pb.cb
    public final void a(Object obj) {
        com.baidu.tieba.model.bb bbVar;
        com.baidu.tieba.model.bb bbVar2;
        com.baidu.tieba.model.bb bbVar3;
        com.baidu.tieba.model.bb bbVar4;
        bbVar = this.a.w;
        String valueOf = String.valueOf(bbVar.q().h().getUserId());
        String valueOf2 = String.valueOf(((Object[]) obj)[1]);
        NewPbActivity newPbActivity = this.a;
        bbVar2 = this.a.w;
        String id = bbVar2.q().c().getId();
        bbVar3 = this.a.w;
        String name = bbVar3.q().c().getName();
        bbVar4 = this.a.w;
        ForbidActivity.a(newPbActivity, id, name, bbVar4.q().d().a(), valueOf, valueOf2);
    }
}
