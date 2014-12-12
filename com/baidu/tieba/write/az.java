package com.baidu.tieba.write;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
class az implements com.baidu.tieba.tbadkCore.location.i {
    final /* synthetic */ WriteActivity cft;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(WriteActivity writeActivity) {
        this.cft = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.i
    public void EZ() {
        com.baidu.tieba.tbadkCore.PbEditor.k kVar;
        this.cft.showToast(com.baidu.tieba.z.no_network_guide);
        kVar = this.cft.cfa;
        kVar.setLocationInfoViewState(0);
    }

    @Override // com.baidu.tieba.tbadkCore.location.i
    public void ft(String str) {
        com.baidu.tieba.tbadkCore.PbEditor.k kVar;
        WriteActivity writeActivity = this.cft;
        if (StringUtils.isNull(str)) {
            str = this.cft.getPageContext().getString(com.baidu.tieba.z.location_fail);
        }
        writeActivity.showToast(str);
        kVar = this.cft.cfa;
        kVar.setLocationInfoViewState(0);
    }

    @Override // com.baidu.tieba.tbadkCore.location.i
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        com.baidu.tieba.tbadkCore.PbEditor.k kVar;
        if (aVar != null && !StringUtils.isNull(aVar.ahu())) {
            kVar = this.cft.cfa;
            kVar.B(2, aVar.ahu());
            return;
        }
        ft(null);
    }
}
