package com.baidu.tieba.pb.main;
/* loaded from: classes.dex */
class ai implements com.baidu.tieba.location.j {
    final /* synthetic */ PbActivity bvu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(PbActivity pbActivity) {
        this.bvu = pbActivity;
    }

    @Override // com.baidu.tieba.location.j
    public void EJ() {
        bv bvVar;
        bv bvVar2;
        bvVar = this.bvu.buZ;
        if (bvVar.EQ() != null) {
            bvVar2 = this.bvu.buZ;
            bvVar2.EQ().setLocationViewVisibility(8);
        }
    }

    @Override // com.baidu.tieba.location.j
    public void eZ(String str) {
        bv bvVar;
        bv bvVar2;
        bv bvVar3;
        bvVar = this.bvu.buZ;
        if (bvVar.EQ() != null) {
            bvVar2 = this.bvu.buZ;
            bvVar2.EQ().setLocationViewVisibility(0);
            bvVar3 = this.bvu.buZ;
            bvVar3.EQ().j(2, str);
        }
    }
}
