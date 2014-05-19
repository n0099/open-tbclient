package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
class l extends com.baidu.adp.base.g {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.adp.base.g
    public void a(Object obj) {
        bj bjVar;
        com.baidu.tieba.model.v vVar;
        com.baidu.tieba.model.v vVar2;
        com.baidu.tieba.model.v vVar3;
        bc bcVar;
        if (obj != null) {
            vVar2 = this.a.D;
            switch (vVar2.getLoadDataMode()) {
                case 0:
                    bcVar = this.a.y;
                    bcVar.z();
                    this.a.a((com.baidu.tieba.model.x) obj);
                    return;
                case 1:
                    this.a.a((com.baidu.tieba.model.z) obj);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    PbActivity pbActivity = this.a;
                    vVar3 = this.a.D;
                    pbActivity.a(vVar3.getLoadDataMode(), (com.baidu.tieba.model.ab) obj);
                    return;
                case 6:
                    this.a.a((com.baidu.tieba.model.ab) obj);
                    return;
                default:
                    return;
            }
        }
        bjVar = this.a.E;
        vVar = this.a.D;
        bjVar.a(vVar.getLoadDataMode(), false, (String) null, false);
    }
}
