package com.baidu.tieba.tbadkCore.f;

import com.baidu.tbadk.core.message.LeftNaviScanMessage;
import java.util.List;
/* loaded from: classes.dex */
class o implements LeftNaviScanMessage.b {
    final /* synthetic */ e dcL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(e eVar) {
        this.dcL = eVar;
    }

    @Override // com.baidu.tbadk.core.message.LeftNaviScanMessage.b
    public void l(List<a> list) {
        com.baidu.tbadk.mvc.g.d dVar;
        dVar = this.dcL.dcG;
        dVar.s(list);
    }
}
