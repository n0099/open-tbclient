package com.baidu.tieba.pb.main;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
class x implements com.baidu.tieba.location.i {
    final /* synthetic */ PbActivity bvg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(PbActivity pbActivity) {
        this.bvg = pbActivity;
    }

    @Override // com.baidu.tieba.location.i
    public void EG() {
        bv bvVar;
        bv bvVar2;
        bv bvVar3;
        bvVar = this.bvg.buL;
        if (bvVar.EO() != null) {
            bvVar2 = this.bvg.buL;
            if (bvVar2.EO().getLocationViewVisibility() == 0) {
                this.bvg.showToast(com.baidu.tieba.y.no_network_guide);
            }
            bvVar3 = this.bvg.buL;
            bvVar3.EO().setLocationInfoViewState(0);
        }
    }

    @Override // com.baidu.tieba.location.i
    public void eY(String str) {
        bv bvVar;
        bv bvVar2;
        bv bvVar3;
        bvVar = this.bvg.buL;
        if (bvVar.EO() != null) {
            bvVar2 = this.bvg.buL;
            if (bvVar2.EO().getLocationViewVisibility() == 0) {
                PbActivity pbActivity = this.bvg;
                if (StringUtils.isNull(str)) {
                    str = this.bvg.getString(com.baidu.tieba.y.location_fail);
                }
                pbActivity.showToast(str);
            }
            bvVar3 = this.bvg.buL;
            bvVar3.EO().setLocationInfoViewState(0);
        }
    }

    @Override // com.baidu.tieba.location.i
    public void a(com.baidu.tieba.location.a aVar) {
        bv bvVar;
        bv bvVar2;
        if (aVar != null && !StringUtils.isNull(aVar.Sl())) {
            bvVar = this.bvg.buL;
            if (bvVar.EO() != null) {
                bvVar2 = this.bvg.buL;
                bvVar2.EO().j(2, aVar.Sl());
                return;
            }
            return;
        }
        eY(null);
    }
}
