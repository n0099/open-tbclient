package com.baidu.tieba.write.write;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.location.d;
/* loaded from: classes.dex */
class av implements d.a {
    final /* synthetic */ WriteActivity dpI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(WriteActivity writeActivity) {
        this.dpI = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void BF() {
        this.dpI.showToast(i.h.no_network_guide);
        this.dpI.a(0, true, (String) null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void fb(String str) {
        WriteActivity writeActivity = this.dpI;
        if (StringUtils.isNull(str)) {
            str = this.dpI.getPageContext().getString(i.h.location_fail);
        }
        writeActivity.showToast(str);
        this.dpI.a(0, true, (String) null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.awY())) {
            fb(null);
        } else {
            this.dpI.a(2, true, aVar.awY());
        }
    }
}
