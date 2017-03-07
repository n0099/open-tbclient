package com.baidu.tieba.write.write;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class bc implements LocationModel.a {
    final /* synthetic */ WriteActivity fQG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(WriteActivity writeActivity) {
        this.fQG = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void DH() {
        this.fQG.showToast(w.l.no_network_guide);
        this.fQG.b(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void fv(String str) {
        WriteActivity writeActivity = this.fQG;
        if (StringUtils.isNull(str)) {
            str = this.fQG.getPageContext().getString(w.l.location_fail);
        }
        writeActivity.showToast(str);
        this.fQG.b(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.bif())) {
            fv(null);
        } else {
            this.fQG.b(2, true, aVar.bif());
        }
    }
}
