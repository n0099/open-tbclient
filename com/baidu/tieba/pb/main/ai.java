package com.baidu.tieba.pb.main;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
class ai implements com.baidu.tieba.tbadkCore.location.i {
    final /* synthetic */ PbActivity bAT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(PbActivity pbActivity) {
        this.bAT = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.i
    public void Fx() {
        bz bzVar;
        bz bzVar2;
        bz bzVar3;
        bzVar = this.bAT.bAx;
        if (bzVar.FF() != null) {
            bzVar2 = this.bAT.bAx;
            if (bzVar2.FF().getLocationViewVisibility() == 0) {
                this.bAT.showToast(com.baidu.tieba.z.no_network_guide);
            }
            bzVar3 = this.bAT.bAx;
            bzVar3.FF().setLocationInfoViewState(0);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.location.i
    public void fy(String str) {
        bz bzVar;
        bz bzVar2;
        bz bzVar3;
        bzVar = this.bAT.bAx;
        if (bzVar.FF() != null) {
            bzVar2 = this.bAT.bAx;
            if (bzVar2.FF().getLocationViewVisibility() == 0) {
                PbActivity pbActivity = this.bAT;
                if (StringUtils.isNull(str)) {
                    str = this.bAT.getPageContext().getString(com.baidu.tieba.z.location_fail);
                }
                pbActivity.showToast(str);
            }
            bzVar3 = this.bAT.bAx;
            bzVar3.FF().setLocationInfoViewState(0);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.location.i
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        bz bzVar;
        bz bzVar2;
        if (aVar != null && !StringUtils.isNull(aVar.ahY())) {
            bzVar = this.bAT.bAx;
            if (bzVar.FF() != null) {
                bzVar2 = this.bAT.bAx;
                bzVar2.FF().B(2, aVar.ahY());
                return;
            }
            return;
        }
        fy(null);
    }
}
