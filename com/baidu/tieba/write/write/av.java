package com.baidu.tieba.write.write;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.location.d;
/* loaded from: classes.dex */
class av implements d.a {
    final /* synthetic */ WriteActivity dYD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(WriteActivity writeActivity) {
        this.dYD = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void Ck() {
        this.dYD.showToast(n.j.no_network_guide);
        this.dYD.a(0, true, (String) null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void fw(String str) {
        WriteActivity writeActivity = this.dYD;
        if (StringUtils.isNull(str)) {
            str = this.dYD.getPageContext().getString(n.j.location_fail);
        }
        writeActivity.showToast(str);
        this.dYD.a(0, true, (String) null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.aFS())) {
            fw(null);
        } else {
            this.dYD.a(2, true, aVar.aFS());
        }
    }
}
