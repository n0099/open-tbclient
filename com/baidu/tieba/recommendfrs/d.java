package com.baidu.tieba.recommendfrs;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.aj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements aj {
    final /* synthetic */ b cbE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.cbE = bVar;
    }

    @Override // com.baidu.tbadk.core.view.aj
    public void onListPullRefresh(boolean z) {
        boolean z2;
        com.baidu.tieba.recommendfrs.control.a.b bVar;
        String str;
        com.baidu.tieba.recommendfrs.control.a.b bVar2;
        String str2;
        TiebaStatic.eventStat(this.cbE.getFragmentActivity(), "kantie_update", null);
        z2 = this.cbE.aDI;
        if (z2) {
            bVar2 = this.cbE.cbv;
            str2 = this.cbE.cbB;
            bVar2.B(0, str2);
            return;
        }
        bVar = this.cbE.cbv;
        str = this.cbE.cbB;
        bVar.iW(str);
    }
}
