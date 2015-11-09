package com.baidu.tieba.write.write;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.location.d;
/* loaded from: classes.dex */
class av implements d.a {
    final /* synthetic */ WriteActivity dsa;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(WriteActivity writeActivity) {
        this.dsa = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void Bv() {
        this.dsa.showToast(i.h.no_network_guide);
        this.dsa.a(0, true, (String) null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void fd(String str) {
        WriteActivity writeActivity = this.dsa;
        if (StringUtils.isNull(str)) {
            str = this.dsa.getPageContext().getString(i.h.location_fail);
        }
        writeActivity.showToast(str);
        this.dsa.a(0, true, (String) null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.ayn())) {
            fd(null);
        } else {
            this.dsa.a(2, true, aVar.ayn());
        }
    }
}
