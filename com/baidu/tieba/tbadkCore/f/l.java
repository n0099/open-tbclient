package com.baidu.tieba.tbadkCore.f;

import com.baidu.tbadk.core.message.LeftNaviScanMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements LeftNaviScanMessage.b {
    final /* synthetic */ e dcL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(e eVar) {
        this.dcL = eVar;
    }

    @Override // com.baidu.tbadk.core.message.LeftNaviScanMessage.b
    public void l(List<a> list) {
        com.baidu.tbadk.mvc.g.d dVar;
        dVar = this.dcL.dcG;
        dVar.s(list);
    }
}
