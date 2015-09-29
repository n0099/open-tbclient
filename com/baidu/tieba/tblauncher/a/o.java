package com.baidu.tieba.tblauncher.a;

import com.baidu.tieba.tblauncher.LeftNaviScanMessage;
import java.util.List;
/* loaded from: classes.dex */
class o implements LeftNaviScanMessage.b {
    final /* synthetic */ e ddy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(e eVar) {
        this.ddy = eVar;
    }

    @Override // com.baidu.tieba.tblauncher.LeftNaviScanMessage.b
    public void bv(List<a> list) {
        com.baidu.tbadk.mvc.g.d dVar;
        dVar = this.ddy.ddt;
        dVar.r(list);
    }
}
