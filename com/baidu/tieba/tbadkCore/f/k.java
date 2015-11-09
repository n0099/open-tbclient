package com.baidu.tieba.tbadkCore.f;

import com.baidu.tbadk.core.message.LeftNaviScanMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements LeftNaviScanMessage.b {
    final /* synthetic */ e dcL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        this.dcL = eVar;
    }

    @Override // com.baidu.tbadk.core.message.LeftNaviScanMessage.b
    public void l(List<a> list) {
        com.baidu.tbadk.mvc.g.d dVar;
        com.baidu.tbadk.mvc.g.d dVar2;
        dVar = this.dcL.dcG;
        dVar.s(list);
        dVar2 = this.dcL.dcG;
        dVar2.notifyDataSetChanged();
    }
}
