package com.baidu.tieba.write.write;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.location.d;
/* loaded from: classes.dex */
class bd implements d.a {
    final /* synthetic */ WriteActivity gpp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(WriteActivity writeActivity) {
        this.gpp = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void DL() {
        this.gpp.showToast(r.j.no_network_guide);
        this.gpp.b(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void fN(String str) {
        WriteActivity writeActivity = this.gpp;
        if (StringUtils.isNull(str)) {
            str = this.gpp.getPageContext().getString(r.j.location_fail);
        }
        writeActivity.showToast(str);
        this.gpp.b(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.getFormatted_address())) {
            fN(null);
        } else {
            this.gpp.b(2, true, aVar.getFormatted_address());
        }
    }
}
