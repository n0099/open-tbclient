package com.baidu.tieba.write.write;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.location.d;
/* loaded from: classes.dex */
class bd implements d.a {
    final /* synthetic */ WriteActivity gfs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(WriteActivity writeActivity) {
        this.gfs = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void DG() {
        this.gfs.showToast(t.j.no_network_guide);
        this.gfs.b(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void fG(String str) {
        WriteActivity writeActivity = this.gfs;
        if (StringUtils.isNull(str)) {
            str = this.gfs.getPageContext().getString(t.j.location_fail);
        }
        writeActivity.showToast(str);
        this.gfs.b(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.getFormatted_address())) {
            fG(null);
        } else {
            this.gfs.b(2, true, aVar.getFormatted_address());
        }
    }
}
