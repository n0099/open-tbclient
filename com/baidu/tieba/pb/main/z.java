package com.baidu.tieba.pb.main;

import com.baidu.tieba.account.forbid.ForbidActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements bf {
    final /* synthetic */ PbActivity bvg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(PbActivity pbActivity) {
        this.bvg = pbActivity;
    }

    @Override // com.baidu.tieba.pb.main.bf
    public void a(Object obj) {
        bn bnVar;
        bn bnVar2;
        bn bnVar3;
        bn bnVar4;
        bnVar = this.bvg.buG;
        String valueOf = String.valueOf(bnVar.getPbData().getUserData().getUserId());
        String valueOf2 = String.valueOf(((Object[]) obj)[1]);
        PbActivity pbActivity = this.bvg;
        bnVar2 = this.bvg.buG;
        String id = bnVar2.getPbData().zJ().getId();
        bnVar3 = this.bvg.buG;
        String name = bnVar3.getPbData().zJ().getName();
        bnVar4 = this.bvg.buG;
        ForbidActivity.startActivity(pbActivity, id, name, bnVar4.getPbData().zK().getId(), valueOf, valueOf2);
    }
}
