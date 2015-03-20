package com.baidu.tieba.recommendfrs;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ae;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements ae {
    final /* synthetic */ b bXH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.bXH = bVar;
    }

    @Override // com.baidu.tbadk.core.view.ae
    public void onListPullRefresh(boolean z) {
        boolean z2;
        com.baidu.tieba.recommendfrs.a.b bVar;
        com.baidu.tieba.recommendfrs.a.b bVar2;
        TiebaStatic.eventStat(this.bXH.getFragmentActivity(), "kantie_update", null);
        z2 = this.bXH.aBE;
        if (z2) {
            bVar2 = this.bXH.bXA;
            bVar2.hM(0);
            return;
        }
        bVar = this.bXH.bXA;
        bVar.FY();
    }
}
