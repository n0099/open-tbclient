package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
class ai implements com.baidu.tieba.tbadkCore.location.j {
    final /* synthetic */ PbActivity bKU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(PbActivity pbActivity) {
        this.bKU = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.j
    public void JX() {
        ch chVar;
        ch chVar2;
        ch chVar3;
        chVar = this.bKU.bKA;
        if (chVar.Kj() != null) {
            chVar2 = this.bKU.bKA;
            if (chVar2.Kj().getLocationViewVisibility() == 0) {
                this.bKU.showToast(com.baidu.tieba.t.no_network_guide);
            }
            chVar3 = this.bKU.bKA;
            chVar3.Kj().setLocationInfoViewState(0);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.location.j
    public void gh(String str) {
        ch chVar;
        ch chVar2;
        ch chVar3;
        chVar = this.bKU.bKA;
        if (chVar.Kj() != null) {
            chVar2 = this.bKU.bKA;
            if (chVar2.Kj().getLocationViewVisibility() == 0) {
                PbActivity pbActivity = this.bKU;
                if (StringUtils.isNull(str)) {
                    str = this.bKU.getPageContext().getString(com.baidu.tieba.t.location_fail);
                }
                pbActivity.showToast(str);
            }
            chVar3 = this.bKU.bKA;
            chVar3.Kj().setLocationInfoViewState(0);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.location.j
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        ch chVar;
        ch chVar2;
        if (aVar != null && !StringUtils.isNull(aVar.ape())) {
            chVar = this.bKU.bKA;
            if (chVar.Kj() != null) {
                chVar2 = this.bKU.bKA;
                chVar2.Kj().D(2, aVar.ape());
                return;
            }
            return;
        }
        gh(null);
    }
}
