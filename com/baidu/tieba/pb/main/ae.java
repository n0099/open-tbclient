package com.baidu.tieba.pb.main;

import com.baidu.tieba.account.forbid.ForbidActivity;
/* loaded from: classes.dex */
final class ae implements aw {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tieba.pb.main.aw
    public final void a(Object obj) {
        bd bdVar;
        bd bdVar2;
        bd bdVar3;
        bd bdVar4;
        bdVar = this.a.x;
        String valueOf = String.valueOf(bdVar.p().h().getUserId());
        String valueOf2 = String.valueOf(((Object[]) obj)[1]);
        PbActivity pbActivity = this.a;
        bdVar2 = this.a.x;
        String id = bdVar2.p().c().getId();
        bdVar3 = this.a.x;
        String name = bdVar3.p().c().getName();
        bdVar4 = this.a.x;
        ForbidActivity.a(pbActivity, id, name, bdVar4.p().d().l(), valueOf, valueOf2);
    }
}
