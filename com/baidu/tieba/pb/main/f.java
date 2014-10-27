package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
class f extends com.baidu.adp.base.h {
    final /* synthetic */ PbActivity bvg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(PbActivity pbActivity) {
        this.bvg = pbActivity;
    }

    @Override // com.baidu.adp.base.h
    public void a(Object obj) {
        bv bvVar;
        com.baidu.tieba.model.v vVar;
        com.baidu.tieba.model.v vVar2;
        com.baidu.tieba.model.v vVar3;
        bn bnVar;
        if (obj != null) {
            vVar2 = this.bvg.buK;
            switch (vVar2.getLoadDataMode()) {
                case 0:
                    bnVar = this.bvg.buG;
                    bnVar.WS();
                    this.bvg.a((com.baidu.tieba.model.x) obj);
                    return;
                case 1:
                    this.bvg.a((com.baidu.tieba.model.z) obj);
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                    PbActivity pbActivity = this.bvg;
                    vVar3 = this.bvg.buK;
                    pbActivity.a(vVar3.getLoadDataMode(), (com.baidu.tieba.model.ab) obj);
                    return;
                case 6:
                    this.bvg.a((com.baidu.tieba.model.ab) obj);
                    return;
                default:
                    return;
            }
        }
        bvVar = this.bvg.buL;
        vVar = this.bvg.buK;
        bvVar.a(vVar.getLoadDataMode(), false, (String) null, false);
    }
}
