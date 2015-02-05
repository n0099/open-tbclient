package com.baidu.tieba.write;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
class az implements com.baidu.tieba.tbadkCore.location.i {
    final /* synthetic */ WriteActivity cgR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(WriteActivity writeActivity) {
        this.cgR = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.i
    public void Fr() {
        com.baidu.tieba.tbadkCore.PbEditor.k kVar;
        this.cgR.showToast(com.baidu.tieba.z.no_network_guide);
        kVar = this.cgR.cgy;
        kVar.setLocationInfoViewState(0);
    }

    @Override // com.baidu.tieba.tbadkCore.location.i
    public void fv(String str) {
        com.baidu.tieba.tbadkCore.PbEditor.k kVar;
        WriteActivity writeActivity = this.cgR;
        if (StringUtils.isNull(str)) {
            str = this.cgR.getPageContext().getString(com.baidu.tieba.z.location_fail);
        }
        writeActivity.showToast(str);
        kVar = this.cgR.cgy;
        kVar.setLocationInfoViewState(0);
    }

    @Override // com.baidu.tieba.tbadkCore.location.i
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        com.baidu.tieba.tbadkCore.PbEditor.k kVar;
        if (aVar != null && !StringUtils.isNull(aVar.ahT())) {
            kVar = this.cgR.cgy;
            kVar.B(2, aVar.ahT());
            return;
        }
        fv(null);
    }
}
