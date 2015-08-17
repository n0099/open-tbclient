package com.baidu.tieba.write.write;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.location.d;
/* loaded from: classes.dex */
class av implements d.a {
    final /* synthetic */ WriteActivity cUM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public av(WriteActivity writeActivity) {
        this.cUM = writeActivity;
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void BF() {
        this.cUM.showToast(i.C0057i.no_network_guide);
        this.cUM.a(0, true, (String) null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void eO(String str) {
        WriteActivity writeActivity = this.cUM;
        if (StringUtils.isNull(str)) {
            str = this.cUM.getPageContext().getString(i.C0057i.location_fail);
        }
        writeActivity.showToast(str);
        this.cUM.a(0, true, (String) null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.aqy())) {
            eO(null);
        } else {
            this.cUM.a(2, true, aVar.aqy());
        }
    }
}
