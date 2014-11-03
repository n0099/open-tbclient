package com.baidu.tieba.pb.main;

import com.baidu.tieba.account.forbid.ForbidActivity;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z implements bf {
    final /* synthetic */ PbActivity bvu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(PbActivity pbActivity) {
        this.bvu = pbActivity;
    }

    @Override // com.baidu.tieba.pb.main.bf
    public void a(Object obj) {
        bn bnVar;
        bn bnVar2;
        bn bnVar3;
        bn bnVar4;
        bnVar = this.bvu.buU;
        String valueOf = String.valueOf(bnVar.getPbData().getUserData().getUserId());
        String valueOf2 = String.valueOf(((Object[]) obj)[1]);
        PbActivity pbActivity = this.bvu;
        bnVar2 = this.bvu.buU;
        String id = bnVar2.getPbData().zL().getId();
        bnVar3 = this.bvu.buU;
        String name = bnVar3.getPbData().zL().getName();
        bnVar4 = this.bvu.buU;
        ForbidActivity.startActivity(pbActivity, id, name, bnVar4.getPbData().zM().getId(), valueOf, valueOf2);
    }
}
