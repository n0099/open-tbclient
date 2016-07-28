package com.baidu.tieba.write.write;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.location.d;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class bd implements d.a {
    final /* synthetic */ WriteActivity fVn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(WriteActivity writeActivity) {
        this.fVn = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void Cl() {
        this.fVn.showToast(u.j.no_network_guide);
        this.fVn.b(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void fD(String str) {
        WriteActivity writeActivity = this.fVn;
        if (StringUtils.isNull(str)) {
            str = this.fVn.getPageContext().getString(u.j.location_fail);
        }
        writeActivity.showToast(str);
        this.fVn.b(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.getFormatted_address())) {
            fD(null);
        } else {
            this.fVn.b(2, true, aVar.getFormatted_address());
        }
    }
}
