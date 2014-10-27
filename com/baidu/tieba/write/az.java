package com.baidu.tieba.write;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
class az implements com.baidu.tieba.location.i {
    final /* synthetic */ WriteActivity bTX;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(WriteActivity writeActivity) {
        this.bTX = writeActivity;
    }

    @Override // com.baidu.tieba.location.i
    public void EG() {
        com.baidu.tieba.editortool.j jVar;
        this.bTX.showToast(com.baidu.tieba.y.no_network_guide);
        jVar = this.bTX.bTE;
        jVar.setLocationInfoViewState(0);
    }

    @Override // com.baidu.tieba.location.i
    public void eY(String str) {
        com.baidu.tieba.editortool.j jVar;
        WriteActivity writeActivity = this.bTX;
        if (StringUtils.isNull(str)) {
            str = this.bTX.getString(com.baidu.tieba.y.location_fail);
        }
        writeActivity.showToast(str);
        jVar = this.bTX.bTE;
        jVar.setLocationInfoViewState(0);
    }

    @Override // com.baidu.tieba.location.i
    public void a(com.baidu.tieba.location.a aVar) {
        com.baidu.tieba.editortool.j jVar;
        if (aVar != null && !StringUtils.isNull(aVar.Sl())) {
            jVar = this.bTX.bTE;
            jVar.j(2, aVar.Sl());
            return;
        }
        eY(null);
    }
}
