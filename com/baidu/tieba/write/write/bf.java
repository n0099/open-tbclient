package com.baidu.tieba.write.write;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
class bf implements com.baidu.tieba.tbadkCore.location.j {
    final /* synthetic */ WriteActivity cCP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(WriteActivity writeActivity) {
        this.cCP = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.j
    public void JW() {
        com.baidu.tieba.write.editor.b bVar;
        this.cCP.showToast(com.baidu.tieba.t.no_network_guide);
        bVar = this.cCP.cCw;
        bVar.setLocationInfoViewState(0);
    }

    @Override // com.baidu.tieba.tbadkCore.location.j
    public void gh(String str) {
        com.baidu.tieba.write.editor.b bVar;
        WriteActivity writeActivity = this.cCP;
        if (StringUtils.isNull(str)) {
            str = this.cCP.getPageContext().getString(com.baidu.tieba.t.location_fail);
        }
        writeActivity.showToast(str);
        bVar = this.cCP.cCw;
        bVar.setLocationInfoViewState(0);
    }

    @Override // com.baidu.tieba.tbadkCore.location.j
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        com.baidu.tieba.write.editor.b bVar;
        if (aVar != null && !StringUtils.isNull(aVar.apd())) {
            bVar = this.cCP.cCw;
            bVar.D(2, aVar.apd());
            return;
        }
        gh(null);
    }
}
