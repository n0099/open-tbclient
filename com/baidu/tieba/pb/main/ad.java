package com.baidu.tieba.pb.main;

import com.baidu.tieba.account.forbid.ForbidActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements bd {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.tieba.pb.main.bd
    public void a(Object obj) {
        bl blVar;
        bl blVar2;
        bl blVar3;
        bl blVar4;
        blVar = this.a.y;
        String valueOf = String.valueOf(blVar.r().h().getUserId());
        String valueOf2 = String.valueOf(((Object[]) obj)[1]);
        PbActivity pbActivity = this.a;
        blVar2 = this.a.y;
        String id = blVar2.r().c().getId();
        blVar3 = this.a.y;
        String name = blVar3.r().c().getName();
        blVar4 = this.a.y;
        ForbidActivity.a(pbActivity, id, name, blVar4.r().d().h(), valueOf, valueOf2);
    }
}
