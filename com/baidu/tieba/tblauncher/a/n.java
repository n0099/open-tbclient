package com.baidu.tieba.tblauncher.a;

import com.baidu.tbadk.core.message.LeftNaviScanMessage;
import java.util.List;
/* loaded from: classes.dex */
class n implements LeftNaviScanMessage.b {
    final /* synthetic */ d cVQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(d dVar) {
        this.cVQ = dVar;
    }

    @Override // com.baidu.tbadk.core.message.LeftNaviScanMessage.b
    public void l(List<com.baidu.tieba.tbadkCore.f.a> list) {
        com.baidu.tbadk.mvc.g.d dVar;
        dVar = this.cVQ.cVL;
        dVar.s(list);
    }
}
