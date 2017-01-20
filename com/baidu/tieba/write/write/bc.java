package com.baidu.tieba.write.write;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.location.LocationModel;
/* loaded from: classes.dex */
class bc implements LocationModel.a {
    final /* synthetic */ WriteActivity fMl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(WriteActivity writeActivity) {
        this.fMl = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void Do() {
        this.fMl.showToast(r.l.no_network_guide);
        this.fMl.b(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void fG(String str) {
        WriteActivity writeActivity = this.fMl;
        if (StringUtils.isNull(str)) {
            str = this.fMl.getPageContext().getString(r.l.location_fail);
        }
        writeActivity.showToast(str);
        this.fMl.b(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.bip())) {
            fG(null);
        } else {
            this.fMl.b(2, true, aVar.bip());
        }
    }
}
