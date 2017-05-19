package com.baidu.tieba.write.write;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class bb implements LocationModel.a {
    final /* synthetic */ WriteActivity fSV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(WriteActivity writeActivity) {
        this.fSV = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void Dj() {
        this.fSV.showToast(w.l.no_network_guide);
        this.fSV.b(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void fy(String str) {
        WriteActivity writeActivity = this.fSV;
        if (StringUtils.isNull(str)) {
            str = this.fSV.getPageContext().getString(w.l.location_fail);
        }
        writeActivity.showToast(str);
        this.fSV.b(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.bho())) {
            fy(null);
        } else {
            this.fSV.b(2, true, aVar.bho());
        }
    }
}
