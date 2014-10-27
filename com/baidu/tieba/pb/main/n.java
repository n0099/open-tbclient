package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
class n implements cw {
    final /* synthetic */ PbActivity bvg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(PbActivity pbActivity) {
        this.bvg = pbActivity;
    }

    @Override // com.baidu.tieba.pb.main.cw
    public void a(com.baidu.tieba.data.ar arVar) {
        com.baidu.tieba.pb.sub.e eVar;
        com.baidu.tieba.pb.sub.e eVar2;
        bv bvVar;
        eVar = this.bvg.buJ;
        if (eVar != null) {
            eVar2 = this.bvg.buJ;
            if (eVar2.tL()) {
                bvVar = this.bvg.buL;
                bvVar.XH();
            }
        }
    }
}
