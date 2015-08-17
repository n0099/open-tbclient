package com.baidu.tieba.tblauncher.a;

import com.baidu.tbadk.core.message.LeftNaviScanMessage;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class j implements LeftNaviScanMessage.b {
    final /* synthetic */ d cNj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(d dVar) {
        this.cNj = dVar;
    }

    @Override // com.baidu.tbadk.core.message.LeftNaviScanMessage.b
    public void k(List<com.baidu.tieba.tbadkCore.f.a> list) {
        com.baidu.tbadk.mvc.g.d dVar;
        com.baidu.tbadk.mvc.g.d dVar2;
        dVar = this.cNj.cNe;
        dVar.r(list);
        dVar2 = this.cNj.cNe;
        dVar2.notifyDataSetChanged();
    }
}
