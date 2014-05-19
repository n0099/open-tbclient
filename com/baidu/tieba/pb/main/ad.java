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
        bc bcVar;
        bc bcVar2;
        bc bcVar3;
        bc bcVar4;
        bcVar = this.a.y;
        String valueOf = String.valueOf(bcVar.p().h().getUserId());
        String valueOf2 = String.valueOf(((Object[]) obj)[1]);
        PbActivity pbActivity = this.a;
        bcVar2 = this.a.y;
        String id = bcVar2.p().c().getId();
        bcVar3 = this.a.y;
        String name = bcVar3.p().c().getName();
        bcVar4 = this.a.y;
        ForbidActivity.a(pbActivity, id, name, bcVar4.p().d().k(), valueOf, valueOf2);
    }
}
