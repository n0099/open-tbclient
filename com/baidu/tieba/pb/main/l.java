package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
class l extends com.baidu.adp.base.e {
    final /* synthetic */ PbActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(PbActivity pbActivity) {
        this.a = pbActivity;
    }

    @Override // com.baidu.adp.base.e
    public void a(Object obj) {
        bq bqVar;
        com.baidu.tieba.model.v vVar;
        com.baidu.tieba.model.v vVar2;
        com.baidu.tieba.model.v vVar3;
        bj bjVar;
        if (obj != null) {
            vVar2 = this.a.C;
            switch (vVar2.getLoadDataMode()) {
                case 0:
                    bjVar = this.a.x;
                    bjVar.z();
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
                    vVar3 = this.a.C;
                    pbActivity.a(vVar3.getLoadDataMode(), (com.baidu.tieba.model.ab) obj);
                    return;
                case 6:
                    this.a.a((com.baidu.tieba.model.ab) obj);
                    return;
                default:
                    return;
            }
        }
        bqVar = this.a.D;
        vVar = this.a.C;
        bqVar.a(vVar.getLoadDataMode(), false, (String) null, false);
    }
}
