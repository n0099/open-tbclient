package com.baidu.tieba.write.write;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.location.d;
/* loaded from: classes.dex */
class av implements d.a {
    final /* synthetic */ WriteActivity ets;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(WriteActivity writeActivity) {
        this.ets = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void DA() {
        this.ets.showToast(t.j.no_network_guide);
        this.ets.a(0, true, (String) null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void fu(String str) {
        WriteActivity writeActivity = this.ets;
        if (StringUtils.isNull(str)) {
            str = this.ets.getPageContext().getString(t.j.location_fail);
        }
        writeActivity.showToast(str);
        this.ets.a(0, true, (String) null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.aMX())) {
            fu(null);
        } else {
            this.ets.a(2, true, aVar.aMX());
        }
    }
}
