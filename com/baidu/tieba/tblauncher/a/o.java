package com.baidu.tieba.tblauncher.a;

import com.baidu.tieba.tblauncher.LeftNaviScanMessage;
import java.util.List;
/* loaded from: classes.dex */
class o implements LeftNaviScanMessage.b {
    final /* synthetic */ e ddY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(e eVar) {
        this.ddY = eVar;
    }

    @Override // com.baidu.tieba.tblauncher.LeftNaviScanMessage.b
    public void bw(List<a> list) {
        com.baidu.tbadk.mvc.g.d dVar;
        dVar = this.ddY.ddT;
        dVar.r(list);
    }
}
