package com.baidu.tieba.write.write;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.location.d;
/* loaded from: classes.dex */
class bd implements d.a {
    final /* synthetic */ WriteActivity fDQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(WriteActivity writeActivity) {
        this.fDQ = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void Dt() {
        this.fDQ.showToast(r.j.no_network_guide);
        this.fDQ.b(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void fJ(String str) {
        WriteActivity writeActivity = this.fDQ;
        if (StringUtils.isNull(str)) {
            str = this.fDQ.getPageContext().getString(r.j.location_fail);
        }
        writeActivity.showToast(str);
        this.fDQ.b(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.bgA())) {
            fJ(null);
        } else {
            this.fDQ.b(2, true, aVar.bgA());
        }
    }
}
