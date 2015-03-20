package com.baidu.tieba.write.write;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
class be implements com.baidu.tieba.tbadkCore.location.j {
    final /* synthetic */ WriteActivity cyc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(WriteActivity writeActivity) {
        this.cyc = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.j
    public void IQ() {
        com.baidu.tieba.write.editor.b bVar;
        this.cyc.showToast(com.baidu.tieba.y.no_network_guide);
        bVar = this.cyc.cxJ;
        bVar.setLocationInfoViewState(0);
    }

    @Override // com.baidu.tieba.tbadkCore.location.j
    public void fE(String str) {
        com.baidu.tieba.write.editor.b bVar;
        WriteActivity writeActivity = this.cyc;
        if (StringUtils.isNull(str)) {
            str = this.cyc.getPageContext().getString(com.baidu.tieba.y.location_fail);
        }
        writeActivity.showToast(str);
        bVar = this.cyc.cxJ;
        bVar.setLocationInfoViewState(0);
    }

    @Override // com.baidu.tieba.tbadkCore.location.j
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        com.baidu.tieba.write.editor.b bVar;
        if (aVar != null && !StringUtils.isNull(aVar.amX())) {
            bVar = this.cyc.cxJ;
            bVar.B(2, aVar.amX());
            return;
        }
        fE(null);
    }
}
