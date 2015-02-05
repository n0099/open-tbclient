package com.baidu.tieba.pb.main;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
class ai implements com.baidu.tieba.tbadkCore.location.i {
    final /* synthetic */ PbActivity bAS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(PbActivity pbActivity) {
        this.bAS = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.i
    public void Fr() {
        bz bzVar;
        bz bzVar2;
        bz bzVar3;
        bzVar = this.bAS.bAw;
        if (bzVar.Fz() != null) {
            bzVar2 = this.bAS.bAw;
            if (bzVar2.Fz().getLocationViewVisibility() == 0) {
                this.bAS.showToast(com.baidu.tieba.z.no_network_guide);
            }
            bzVar3 = this.bAS.bAw;
            bzVar3.Fz().setLocationInfoViewState(0);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.location.i
    public void fv(String str) {
        bz bzVar;
        bz bzVar2;
        bz bzVar3;
        bzVar = this.bAS.bAw;
        if (bzVar.Fz() != null) {
            bzVar2 = this.bAS.bAw;
            if (bzVar2.Fz().getLocationViewVisibility() == 0) {
                PbActivity pbActivity = this.bAS;
                if (StringUtils.isNull(str)) {
                    str = this.bAS.getPageContext().getString(com.baidu.tieba.z.location_fail);
                }
                pbActivity.showToast(str);
            }
            bzVar3 = this.bAS.bAw;
            bzVar3.Fz().setLocationInfoViewState(0);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.location.i
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        bz bzVar;
        bz bzVar2;
        if (aVar != null && !StringUtils.isNull(aVar.ahT())) {
            bzVar = this.bAS.bAw;
            if (bzVar.Fz() != null) {
                bzVar2 = this.bAS.bAw;
                bzVar2.Fz().B(2, aVar.ahT());
                return;
            }
            return;
        }
        fv(null);
    }
}
