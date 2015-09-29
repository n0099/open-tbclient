package com.baidu.tieba.tblauncher.a;

import com.baidu.tieba.tblauncher.LeftNaviScanMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements LeftNaviScanMessage.b {
    final /* synthetic */ e ddy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(e eVar) {
        this.ddy = eVar;
    }

    @Override // com.baidu.tieba.tblauncher.LeftNaviScanMessage.b
    public void bv(List<a> list) {
        com.baidu.tbadk.mvc.g.d dVar;
        com.baidu.tbadk.mvc.g.d dVar2;
        dVar = this.ddy.ddt;
        dVar.r(list);
        dVar2 = this.ddy.ddt;
        dVar2.notifyDataSetChanged();
    }
}
