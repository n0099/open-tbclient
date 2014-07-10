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
        bt btVar;
        com.baidu.tieba.model.t tVar;
        com.baidu.tieba.model.t tVar2;
        com.baidu.tieba.model.t tVar3;
        bm bmVar;
        if (obj != null) {
            tVar2 = this.a.C;
            switch (tVar2.getLoadDataMode()) {
                case 0:
                    bmVar = this.a.x;
                    bmVar.D();
                    this.a.a((com.baidu.tieba.model.v) obj);
                    return;
                case 1:
                    this.a.a((com.baidu.tieba.model.x) obj);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    PbActivity pbActivity = this.a;
                    tVar3 = this.a.C;
                    pbActivity.a(tVar3.getLoadDataMode(), (com.baidu.tieba.model.z) obj);
                    return;
                case 6:
                    this.a.a((com.baidu.tieba.model.z) obj);
                    return;
                default:
                    return;
            }
        }
        btVar = this.a.D;
        tVar = this.a.C;
        btVar.a(tVar.getLoadDataMode(), false, (String) null, false);
    }
}
