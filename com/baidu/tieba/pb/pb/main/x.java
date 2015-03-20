package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
class x implements com.baidu.tieba.tbadkCore.location.j {
    final /* synthetic */ PbActivity bIv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(PbActivity pbActivity) {
        this.bIv = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.j
    public void IQ() {
        ci ciVar;
        ci ciVar2;
        ci ciVar3;
        ciVar = this.bIv.bHY;
        if (ciVar.IY() != null) {
            ciVar2 = this.bIv.bHY;
            if (ciVar2.IY().getLocationViewVisibility() == 0) {
                this.bIv.showToast(com.baidu.tieba.y.no_network_guide);
            }
            ciVar3 = this.bIv.bHY;
            ciVar3.IY().setLocationInfoViewState(0);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.location.j
    public void fE(String str) {
        ci ciVar;
        ci ciVar2;
        ci ciVar3;
        ciVar = this.bIv.bHY;
        if (ciVar.IY() != null) {
            ciVar2 = this.bIv.bHY;
            if (ciVar2.IY().getLocationViewVisibility() == 0) {
                PbActivity pbActivity = this.bIv;
                if (StringUtils.isNull(str)) {
                    str = this.bIv.getPageContext().getString(com.baidu.tieba.y.location_fail);
                }
                pbActivity.showToast(str);
            }
            ciVar3 = this.bIv.bHY;
            ciVar3.IY().setLocationInfoViewState(0);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.location.j
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        ci ciVar;
        ci ciVar2;
        if (aVar != null && !StringUtils.isNull(aVar.amX())) {
            ciVar = this.bIv.bHY;
            if (ciVar.IY() != null) {
                ciVar2 = this.bIv.bHY;
                ciVar2.IY().B(2, aVar.amX());
                return;
            }
            return;
        }
        fE(null);
    }
}
