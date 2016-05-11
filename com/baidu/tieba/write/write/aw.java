package com.baidu.tieba.write.write;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.location.d;
/* loaded from: classes.dex */
class aw implements d.a {
    final /* synthetic */ WriteActivity feb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(WriteActivity writeActivity) {
        this.feb = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void Cd() {
        this.feb.showToast(t.j.no_network_guide);
        this.feb.a(0, true, (String) null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void fz(String str) {
        WriteActivity writeActivity = this.feb;
        if (StringUtils.isNull(str)) {
            str = this.feb.getPageContext().getString(t.j.location_fail);
        }
        writeActivity.showToast(str);
        this.feb.a(0, true, (String) null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.getFormatted_address())) {
            fz(null);
        } else {
            this.feb.a(2, true, aVar.getFormatted_address());
        }
    }
}
