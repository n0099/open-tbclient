package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
class l extends com.baidu.adp.base.h {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        bs bsVar;
        com.baidu.tieba.model.u uVar;
        com.baidu.tieba.model.u uVar2;
        com.baidu.tieba.model.u uVar3;
        bl blVar;
        if (obj != null) {
            uVar2 = this.a.C;
            switch (uVar2.getLoadDataMode()) {
                case 0:
                    blVar = this.a.x;
                    blVar.D();
                    this.a.a((com.baidu.tieba.model.w) obj);
                    return;
                case 1:
                    this.a.a((com.baidu.tieba.model.y) obj);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    PbActivity pbActivity = this.a;
                    uVar3 = this.a.C;
                    pbActivity.a(uVar3.getLoadDataMode(), (com.baidu.tieba.model.aa) obj);
                    return;
                case 6:
                    this.a.a((com.baidu.tieba.model.aa) obj);
                    return;
                default:
                    return;
            }
        }
        bsVar = this.a.D;
        uVar = this.a.C;
        bsVar.a(uVar.getLoadDataMode(), false, (String) null, false);
    }
}
