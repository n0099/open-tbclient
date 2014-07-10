package com.baidu.tieba.pb.main;

import com.baidu.tieba.account.forbid.ForbidActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements ba {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tieba.pb.main.ba
    public void a(Object obj) {
        bm bmVar;
        bm bmVar2;
        bm bmVar3;
        bm bmVar4;
        bmVar = this.a.x;
        String valueOf = String.valueOf(bmVar.r().g().getUserId());
        String valueOf2 = String.valueOf(((Object[]) obj)[1]);
        PbActivity pbActivity = this.a;
        bmVar2 = this.a.x;
        String id = bmVar2.r().b().getId();
        bmVar3 = this.a.x;
        String name = bmVar3.r().b().getName();
        bmVar4 = this.a.x;
        ForbidActivity.a(pbActivity, id, name, bmVar4.r().c().p(), valueOf, valueOf2);
    }
}
