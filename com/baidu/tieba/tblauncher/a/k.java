package com.baidu.tieba.tblauncher.a;

import com.baidu.tieba.tblauncher.LeftNaviScanMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements LeftNaviScanMessage.b {
    final /* synthetic */ e ddY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        this.ddY = eVar;
    }

    @Override // com.baidu.tieba.tblauncher.LeftNaviScanMessage.b
    public void bw(List<a> list) {
        com.baidu.tbadk.mvc.g.d dVar;
        com.baidu.tbadk.mvc.g.d dVar2;
        dVar = this.ddY.ddT;
        dVar.r(list);
        dVar2 = this.ddY.ddT;
        dVar2.notifyDataSetChanged();
    }
}
