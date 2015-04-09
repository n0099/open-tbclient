package com.baidu.tieba.write.write;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
class be implements com.baidu.tieba.tbadkCore.location.j {
    final /* synthetic */ WriteActivity cyx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public be(WriteActivity writeActivity) {
        this.cyx = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.j
    public void IW() {
        com.baidu.tieba.write.editor.b bVar;
        this.cyx.showToast(com.baidu.tieba.y.no_network_guide);
        bVar = this.cyx.cye;
        bVar.setLocationInfoViewState(0);
    }

    @Override // com.baidu.tieba.tbadkCore.location.j
    public void fH(String str) {
        com.baidu.tieba.write.editor.b bVar;
        WriteActivity writeActivity = this.cyx;
        if (StringUtils.isNull(str)) {
            str = this.cyx.getPageContext().getString(com.baidu.tieba.y.location_fail);
        }
        writeActivity.showToast(str);
        bVar = this.cyx.cye;
        bVar.setLocationInfoViewState(0);
    }

    @Override // com.baidu.tieba.tbadkCore.location.j
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        com.baidu.tieba.write.editor.b bVar;
        if (aVar != null && !StringUtils.isNull(aVar.anm())) {
            bVar = this.cyx.cye;
            bVar.B(2, aVar.anm());
            return;
        }
        fH(null);
    }
}
