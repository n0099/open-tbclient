package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
class ai implements com.baidu.tieba.location.j {
    final /* synthetic */ PbActivity bvg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(PbActivity pbActivity) {
        this.bvg = pbActivity;
    }

    @Override // com.baidu.tieba.location.j
    public void EH() {
        bv bvVar;
        bv bvVar2;
        bvVar = this.bvg.buL;
        if (bvVar.EO() != null) {
            bvVar2 = this.bvg.buL;
            bvVar2.EO().setLocationViewVisibility(8);
        }
    }

    @Override // com.baidu.tieba.location.j
    public void eZ(String str) {
        bv bvVar;
        bv bvVar2;
        bv bvVar3;
        bvVar = this.bvg.buL;
        if (bvVar.EO() != null) {
            bvVar2 = this.bvg.buL;
            bvVar2.EO().setLocationViewVisibility(0);
            bvVar3 = this.bvg.buL;
            bvVar3.EO().j(2, str);
        }
    }
}
