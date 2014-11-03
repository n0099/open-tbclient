package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
class f extends com.baidu.adp.base.h {
    final /* synthetic */ PbActivity bvu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PbActivity pbActivity) {
        this.bvu = pbActivity;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        bv bvVar;
        com.baidu.tieba.model.v vVar;
        com.baidu.tieba.model.v vVar2;
        com.baidu.tieba.model.v vVar3;
        bn bnVar;
        if (obj != null) {
            vVar2 = this.bvu.buY;
            switch (vVar2.getLoadDataMode()) {
                case 0:
                    bnVar = this.bvu.buU;
                    bnVar.WV();
                    this.bvu.a((com.baidu.tieba.model.x) obj);
                    return;
                case 1:
                    this.bvu.a((com.baidu.tieba.model.z) obj);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    PbActivity pbActivity = this.bvu;
                    vVar3 = this.bvu.buY;
                    pbActivity.a(vVar3.getLoadDataMode(), (com.baidu.tieba.model.ab) obj);
                    return;
                case 6:
                    this.bvu.a((com.baidu.tieba.model.ab) obj);
                    return;
                default:
                    return;
            }
        }
        bvVar = this.bvu.buZ;
        vVar = this.bvu.buY;
        bvVar.a(vVar.getLoadDataMode(), false, (String) null, false);
    }
}
