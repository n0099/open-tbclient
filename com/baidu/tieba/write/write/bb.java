package com.baidu.tieba.write.write;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class bb implements LocationModel.a {
    final /* synthetic */ WriteActivity glP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(WriteActivity writeActivity) {
        this.glP = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void Dx() {
        this.glP.showToast(w.l.no_network_guide);
        this.glP.b(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void fQ(String str) {
        WriteActivity writeActivity = this.glP;
        if (StringUtils.isNull(str)) {
            str = this.glP.getPageContext().getString(w.l.location_fail);
        }
        writeActivity.showToast(str);
        this.glP.b(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.bmW())) {
            fQ(null);
        } else {
            this.glP.b(2, true, aVar.bmW());
        }
    }
}
