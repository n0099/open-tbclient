package com.baidu.tieba.pb.main;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
class ai implements com.baidu.tieba.tbadkCore.location.i {
    final /* synthetic */ PbActivity bzj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(PbActivity pbActivity) {
        this.bzj = pbActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.i
    public void EZ() {
        bz bzVar;
        bz bzVar2;
        bz bzVar3;
        bzVar = this.bzj.byO;
        if (bzVar.Fh() != null) {
            bzVar2 = this.bzj.byO;
            if (bzVar2.Fh().getLocationViewVisibility() == 0) {
                this.bzj.showToast(com.baidu.tieba.z.no_network_guide);
            }
            bzVar3 = this.bzj.byO;
            bzVar3.Fh().setLocationInfoViewState(0);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.location.i
    public void ft(String str) {
        bz bzVar;
        bz bzVar2;
        bz bzVar3;
        bzVar = this.bzj.byO;
        if (bzVar.Fh() != null) {
            bzVar2 = this.bzj.byO;
            if (bzVar2.Fh().getLocationViewVisibility() == 0) {
                PbActivity pbActivity = this.bzj;
                if (StringUtils.isNull(str)) {
                    str = this.bzj.getPageContext().getString(com.baidu.tieba.z.location_fail);
                }
                pbActivity.showToast(str);
            }
            bzVar3 = this.bzj.byO;
            bzVar3.Fh().setLocationInfoViewState(0);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.location.i
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        bz bzVar;
        bz bzVar2;
        if (aVar != null && !StringUtils.isNull(aVar.ahu())) {
            bzVar = this.bzj.byO;
            if (bzVar.Fh() != null) {
                bzVar2 = this.bzj.byO;
                bzVar2.Fh().B(2, aVar.ahu());
                return;
            }
            return;
        }
        ft(null);
    }
}
