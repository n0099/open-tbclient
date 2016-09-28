package com.baidu.tieba.write.write;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.location.d;
/* loaded from: classes.dex */
class bd implements d.a {
    final /* synthetic */ WriteActivity ghD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(WriteActivity writeActivity) {
        this.ghD = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void DG() {
        this.ghD.showToast(r.j.no_network_guide);
        this.ghD.b(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void fK(String str) {
        WriteActivity writeActivity = this.ghD;
        if (StringUtils.isNull(str)) {
            str = this.ghD.getPageContext().getString(r.j.location_fail);
        }
        writeActivity.showToast(str);
        this.ghD.b(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.getFormatted_address())) {
            fK(null);
        } else {
            this.ghD.b(2, true, aVar.getFormatted_address());
        }
    }
}
