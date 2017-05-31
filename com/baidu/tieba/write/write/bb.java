package com.baidu.tieba.write.write;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class bb implements LocationModel.a {
    final /* synthetic */ WriteActivity gaR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(WriteActivity writeActivity) {
        this.gaR = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void Dd() {
        this.gaR.showToast(w.l.no_network_guide);
        this.gaR.b(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void fw(String str) {
        WriteActivity writeActivity = this.gaR;
        if (StringUtils.isNull(str)) {
            str = this.gaR.getPageContext().getString(w.l.location_fail);
        }
        writeActivity.showToast(str);
        this.gaR.b(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.biI())) {
            fw(null);
        } else {
            this.gaR.b(2, true, aVar.biI());
        }
    }
}
