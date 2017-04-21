package com.baidu.tieba.write.write;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class bb implements LocationModel.a {
    final /* synthetic */ WriteActivity fUM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bb(WriteActivity writeActivity) {
        this.fUM = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void Ef() {
        this.fUM.showToast(w.l.no_network_guide);
        this.fUM.b(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void fB(String str) {
        WriteActivity writeActivity = this.fUM;
        if (StringUtils.isNull(str)) {
            str = this.fUM.getPageContext().getString(w.l.location_fail);
        }
        writeActivity.showToast(str);
        this.fUM.b(0, true, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.bjR())) {
            fB(null);
        } else {
            this.fUM.b(2, true, aVar.bjR());
        }
    }
}
