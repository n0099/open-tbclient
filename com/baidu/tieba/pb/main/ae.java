package com.baidu.tieba.pb.main;

import com.baidu.tieba.account.forbid.ForbidActivity;
/* loaded from: classes.dex */
final class ae implements ay {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tieba.pb.main.ay
    public final void a(Object obj) {
        bf bfVar;
        bf bfVar2;
        bf bfVar3;
        bf bfVar4;
        bfVar = this.a.x;
        String valueOf = String.valueOf(bfVar.p().h().getUserId());
        String valueOf2 = String.valueOf(((Object[]) obj)[1]);
        PbActivity pbActivity = this.a;
        bfVar2 = this.a.x;
        String id = bfVar2.p().c().getId();
        bfVar3 = this.a.x;
        String name = bfVar3.p().c().getName();
        bfVar4 = this.a.x;
        ForbidActivity.a(pbActivity, id, name, bfVar4.p().d().l(), valueOf, valueOf2);
    }
}
