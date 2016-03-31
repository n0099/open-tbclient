package com.baidu.tieba.write.write;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.location.d;
/* loaded from: classes.dex */
class aw implements d.a {
    final /* synthetic */ WriteActivity eNd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aw(WriteActivity writeActivity) {
        this.eNd = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void Ek() {
        this.eNd.showToast(t.j.no_network_guide);
        this.eNd.a(0, true, (String) null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void fC(String str) {
        WriteActivity writeActivity = this.eNd;
        if (StringUtils.isNull(str)) {
            str = this.eNd.getPageContext().getString(t.j.location_fail);
        }
        writeActivity.showToast(str);
        this.eNd.a(0, true, (String) null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.aTZ())) {
            fC(null);
        } else {
            this.eNd.a(2, true, aVar.aTZ());
        }
    }
}
