package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
class x implements com.baidu.tieba.tbadkCore.location.j {
    final /* synthetic */ PbActivity bIJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(PbActivity pbActivity) {
        this.bIJ = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.j
    public void IW() {
        cj cjVar;
        cj cjVar2;
        cj cjVar3;
        cjVar = this.bIJ.bIl;
        if (cjVar.Je() != null) {
            cjVar2 = this.bIJ.bIl;
            if (cjVar2.Je().getLocationViewVisibility() == 0) {
                this.bIJ.showToast(com.baidu.tieba.y.no_network_guide);
            }
            cjVar3 = this.bIJ.bIl;
            cjVar3.Je().setLocationInfoViewState(0);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.location.j
    public void fH(String str) {
        cj cjVar;
        cj cjVar2;
        cj cjVar3;
        cjVar = this.bIJ.bIl;
        if (cjVar.Je() != null) {
            cjVar2 = this.bIJ.bIl;
            if (cjVar2.Je().getLocationViewVisibility() == 0) {
                PbActivity pbActivity = this.bIJ;
                if (StringUtils.isNull(str)) {
                    str = this.bIJ.getPageContext().getString(com.baidu.tieba.y.location_fail);
                }
                pbActivity.showToast(str);
            }
            cjVar3 = this.bIJ.bIl;
            cjVar3.Je().setLocationInfoViewState(0);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.location.j
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        cj cjVar;
        cj cjVar2;
        if (aVar != null && !StringUtils.isNull(aVar.anm())) {
            cjVar = this.bIJ.bIl;
            if (cjVar.Je() != null) {
                cjVar2 = this.bIJ.bIl;
                cjVar2.Je().B(2, aVar.anm());
                return;
            }
            return;
        }
        fH(null);
    }
}
