package com.baidu.tieba.pb.main;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
class x implements com.baidu.tieba.location.i {
    final /* synthetic */ PbActivity bvu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(PbActivity pbActivity) {
        this.bvu = pbActivity;
    }

    @Override // com.baidu.tieba.location.i
    public void EI() {
        bv bvVar;
        bv bvVar2;
        bv bvVar3;
        bvVar = this.bvu.buZ;
        if (bvVar.EQ() != null) {
            bvVar2 = this.bvu.buZ;
            if (bvVar2.EQ().getLocationViewVisibility() == 0) {
                this.bvu.showToast(com.baidu.tieba.y.no_network_guide);
            }
            bvVar3 = this.bvu.buZ;
            bvVar3.EQ().setLocationInfoViewState(0);
        }
    }

    @Override // com.baidu.tieba.location.i
    public void eY(String str) {
        bv bvVar;
        bv bvVar2;
        bv bvVar3;
        bvVar = this.bvu.buZ;
        if (bvVar.EQ() != null) {
            bvVar2 = this.bvu.buZ;
            if (bvVar2.EQ().getLocationViewVisibility() == 0) {
                PbActivity pbActivity = this.bvu;
                if (StringUtils.isNull(str)) {
                    str = this.bvu.getString(com.baidu.tieba.y.location_fail);
                }
                pbActivity.showToast(str);
            }
            bvVar3 = this.bvu.buZ;
            bvVar3.EQ().setLocationInfoViewState(0);
        }
    }

    @Override // com.baidu.tieba.location.i
    public void a(com.baidu.tieba.location.a aVar) {
        bv bvVar;
        bv bvVar2;
        if (aVar != null && !StringUtils.isNull(aVar.So())) {
            bvVar = this.bvu.buZ;
            if (bvVar.EQ() != null) {
                bvVar2 = this.bvu.buZ;
                bvVar2.EQ().j(2, aVar.So());
                return;
            }
            return;
        }
        eY(null);
    }
}
