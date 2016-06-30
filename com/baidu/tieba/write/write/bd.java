package com.baidu.tieba.write.write;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.location.d;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
class bd implements d.a {
    final /* synthetic */ WriteActivity fJw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(WriteActivity writeActivity) {
        this.fJw = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void Cm() {
        this.fJw.showToast(u.j.no_network_guide);
        this.fJw.a(0, true, (String) null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void fF(String str) {
        WriteActivity writeActivity = this.fJw;
        if (StringUtils.isNull(str)) {
            str = this.fJw.getPageContext().getString(u.j.location_fail);
        }
        writeActivity.showToast(str);
        this.fJw.a(0, true, (String) null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.getFormatted_address())) {
            fF(null);
        } else {
            this.fJw.a(2, true, aVar.getFormatted_address());
        }
    }
}
