package com.baidu.tieba.write;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
class az implements com.baidu.tieba.location.i {
    final /* synthetic */ WriteActivity bUm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public az(WriteActivity writeActivity) {
        this.bUm = writeActivity;
    }

    @Override // com.baidu.tieba.location.i
    public void EI() {
        com.baidu.tieba.editortool.j jVar;
        this.bUm.showToast(com.baidu.tieba.y.no_network_guide);
        jVar = this.bUm.bTT;
        jVar.setLocationInfoViewState(0);
    }

    @Override // com.baidu.tieba.location.i
    public void eY(String str) {
        com.baidu.tieba.editortool.j jVar;
        WriteActivity writeActivity = this.bUm;
        if (StringUtils.isNull(str)) {
            str = this.bUm.getString(com.baidu.tieba.y.location_fail);
        }
        writeActivity.showToast(str);
        jVar = this.bUm.bTT;
        jVar.setLocationInfoViewState(0);
    }

    @Override // com.baidu.tieba.location.i
    public void a(com.baidu.tieba.location.a aVar) {
        com.baidu.tieba.editortool.j jVar;
        if (aVar != null && !StringUtils.isNull(aVar.So())) {
            jVar = this.bUm.bTT;
            jVar.j(2, aVar.So());
            return;
        }
        eY(null);
    }
}
