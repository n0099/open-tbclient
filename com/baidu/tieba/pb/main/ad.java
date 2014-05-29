package com.baidu.tieba.pb.main;

import com.baidu.tieba.account.forbid.ForbidActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements ax {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tieba.pb.main.ax
    public void a(Object obj) {
        bj bjVar;
        bj bjVar2;
        bj bjVar3;
        bj bjVar4;
        bjVar = this.a.x;
        String valueOf = String.valueOf(bjVar.q().h().getUserId());
        String valueOf2 = String.valueOf(((Object[]) obj)[1]);
        PbActivity pbActivity = this.a;
        bjVar2 = this.a.x;
        String id = bjVar2.q().c().getId();
        bjVar3 = this.a.x;
        String name = bjVar3.q().c().getName();
        bjVar4 = this.a.x;
        ForbidActivity.a(pbActivity, id, name, bjVar4.q().d().p(), valueOf, valueOf2);
    }
}
