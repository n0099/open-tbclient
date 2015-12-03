package com.baidu.tieba.write.write;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.location.d;
/* loaded from: classes.dex */
class av implements d.a {
    final /* synthetic */ WriteActivity dRf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(WriteActivity writeActivity) {
        this.dRf = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void Cv() {
        this.dRf.showToast(n.i.no_network_guide);
        this.dRf.a(0, true, (String) null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void fs(String str) {
        WriteActivity writeActivity = this.dRf;
        if (StringUtils.isNull(str)) {
            str = this.dRf.getPageContext().getString(n.i.location_fail);
        }
        writeActivity.showToast(str);
        this.dRf.a(0, true, (String) null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.aDF())) {
            fs(null);
        } else {
            this.dRf.a(2, true, aVar.aDF());
        }
    }
}
