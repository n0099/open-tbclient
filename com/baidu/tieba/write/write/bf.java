package com.baidu.tieba.write.write;

import com.baidu.adp.lib.util.StringUtils;
/* loaded from: classes.dex */
class bf implements com.baidu.tieba.tbadkCore.location.j {
    final /* synthetic */ WriteActivity cCQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bf(WriteActivity writeActivity) {
        this.cCQ = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.j
    public void JX() {
        com.baidu.tieba.write.editor.b bVar;
        this.cCQ.showToast(com.baidu.tieba.t.no_network_guide);
        bVar = this.cCQ.cCx;
        bVar.setLocationInfoViewState(0);
    }

    @Override // com.baidu.tieba.tbadkCore.location.j
    public void gh(String str) {
        com.baidu.tieba.write.editor.b bVar;
        WriteActivity writeActivity = this.cCQ;
        if (StringUtils.isNull(str)) {
            str = this.cCQ.getPageContext().getString(com.baidu.tieba.t.location_fail);
        }
        writeActivity.showToast(str);
        bVar = this.cCQ.cCx;
        bVar.setLocationInfoViewState(0);
    }

    @Override // com.baidu.tieba.tbadkCore.location.j
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        com.baidu.tieba.write.editor.b bVar;
        if (aVar != null && !StringUtils.isNull(aVar.ape())) {
            bVar = this.cCQ.cCx;
            bVar.D(2, aVar.ape());
            return;
        }
        gh(null);
    }
}
