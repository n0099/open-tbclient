package com.baidu.tieba.write.write;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.location.d;
/* loaded from: classes.dex */
class av implements d.a {
    final /* synthetic */ WriteActivity ddQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(WriteActivity writeActivity) {
        this.ddQ = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void BS() {
        this.ddQ.showToast(i.h.no_network_guide);
        this.ddQ.a(0, true, (String) null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void eW(String str) {
        WriteActivity writeActivity = this.ddQ;
        if (StringUtils.isNull(str)) {
            str = this.ddQ.getPageContext().getString(i.h.location_fail);
        }
        writeActivity.showToast(str);
        this.ddQ.a(0, true, (String) null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.auM())) {
            eW(null);
        } else {
            this.ddQ.a(2, true, aVar.auM());
        }
    }
}
