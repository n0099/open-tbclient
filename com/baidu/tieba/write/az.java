package com.baidu.tieba.write;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
class az implements com.baidu.tieba.tbadkCore.location.i {
    final /* synthetic */ WriteActivity cgS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(WriteActivity writeActivity) {
        this.cgS = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.i
    public void Fx() {
        com.baidu.tieba.tbadkCore.PbEditor.k kVar;
        this.cgS.showToast(com.baidu.tieba.z.no_network_guide);
        kVar = this.cgS.cgz;
        kVar.setLocationInfoViewState(0);
    }

    @Override // com.baidu.tieba.tbadkCore.location.i
    public void fy(String str) {
        com.baidu.tieba.tbadkCore.PbEditor.k kVar;
        WriteActivity writeActivity = this.cgS;
        if (StringUtils.isNull(str)) {
            str = this.cgS.getPageContext().getString(com.baidu.tieba.z.location_fail);
        }
        writeActivity.showToast(str);
        kVar = this.cgS.cgz;
        kVar.setLocationInfoViewState(0);
    }

    @Override // com.baidu.tieba.tbadkCore.location.i
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        com.baidu.tieba.tbadkCore.PbEditor.k kVar;
        if (aVar != null && !StringUtils.isNull(aVar.ahY())) {
            kVar = this.cgS.cgz;
            kVar.B(2, aVar.ahY());
            return;
        }
        fy(null);
    }
}
