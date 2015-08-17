package com.baidu.tieba.tblauncher.a;

import com.baidu.tbadk.core.message.LeftNaviScanMessage;
import java.util.List;
/* loaded from: classes.dex */
class n implements LeftNaviScanMessage.b {
    final /* synthetic */ d cNj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(d dVar) {
        this.cNj = dVar;
    }

    @Override // com.baidu.tbadk.core.message.LeftNaviScanMessage.b
    public void k(List<com.baidu.tieba.tbadkCore.f.a> list) {
        com.baidu.tbadk.mvc.g.d dVar;
        dVar = this.cNj.cNe;
        dVar.r(list);
    }
}
