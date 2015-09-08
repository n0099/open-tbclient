package com.baidu.tieba.tblauncher.a;

import com.baidu.tbadk.core.message.LeftNaviScanMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements LeftNaviScanMessage.b {
    final /* synthetic */ d cVQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(d dVar) {
        this.cVQ = dVar;
    }

    @Override // com.baidu.tbadk.core.message.LeftNaviScanMessage.b
    public void l(List<com.baidu.tieba.tbadkCore.f.a> list) {
        com.baidu.tbadk.mvc.g.d dVar;
        dVar = this.cVQ.cVL;
        dVar.s(list);
    }
}
