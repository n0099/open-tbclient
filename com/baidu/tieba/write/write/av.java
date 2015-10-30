package com.baidu.tieba.write.write;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.location.d;
/* loaded from: classes.dex */
class av implements d.a {
    final /* synthetic */ WriteActivity dqi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(WriteActivity writeActivity) {
        this.dqi = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void BC() {
        this.dqi.showToast(i.h.no_network_guide);
        this.dqi.a(0, true, (String) null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void fb(String str) {
        WriteActivity writeActivity = this.dqi;
        if (StringUtils.isNull(str)) {
            str = this.dqi.getPageContext().getString(i.h.location_fail);
        }
        writeActivity.showToast(str);
        this.dqi.a(0, true, (String) null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.axe())) {
            fb(null);
        } else {
            this.dqi.a(2, true, aVar.axe());
        }
    }
}
