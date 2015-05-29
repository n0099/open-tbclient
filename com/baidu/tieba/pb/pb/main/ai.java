package com.baidu.tieba.pb.pb.main;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
class ai implements com.baidu.tieba.tbadkCore.location.j {
    final /* synthetic */ PbActivity bKT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(PbActivity pbActivity) {
        this.bKT = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.j
    public void JW() {
        ch chVar;
        ch chVar2;
        ch chVar3;
        chVar = this.bKT.bKz;
        if (chVar.Ki() != null) {
            chVar2 = this.bKT.bKz;
            if (chVar2.Ki().getLocationViewVisibility() == 0) {
                this.bKT.showToast(com.baidu.tieba.t.no_network_guide);
            }
            chVar3 = this.bKT.bKz;
            chVar3.Ki().setLocationInfoViewState(0);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.location.j
    public void gh(String str) {
        ch chVar;
        ch chVar2;
        ch chVar3;
        chVar = this.bKT.bKz;
        if (chVar.Ki() != null) {
            chVar2 = this.bKT.bKz;
            if (chVar2.Ki().getLocationViewVisibility() == 0) {
                PbActivity pbActivity = this.bKT;
                if (StringUtils.isNull(str)) {
                    str = this.bKT.getPageContext().getString(com.baidu.tieba.t.location_fail);
                }
                pbActivity.showToast(str);
            }
            chVar3 = this.bKT.bKz;
            chVar3.Ki().setLocationInfoViewState(0);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.location.j
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        ch chVar;
        ch chVar2;
        if (aVar != null && !StringUtils.isNull(aVar.apd())) {
            chVar = this.bKT.bKz;
            if (chVar.Ki() != null) {
                chVar2 = this.bKT.bKz;
                chVar2.Ki().D(2, aVar.apd());
                return;
            }
            return;
        }
        gh(null);
    }
}
