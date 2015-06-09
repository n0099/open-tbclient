package com.baidu.tieba.recommendfrs;

import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.aj;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements aj {
    final /* synthetic */ b cbF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.cbF = bVar;
    }

    @Override // com.baidu.tbadk.core.view.aj
    public void onListPullRefresh(boolean z) {
        boolean z2;
        com.baidu.tieba.recommendfrs.control.a.b bVar;
        String str;
        com.baidu.tieba.recommendfrs.control.a.b bVar2;
        String str2;
        TiebaStatic.eventStat(this.cbF.getFragmentActivity(), "kantie_update", null);
        z2 = this.cbF.aDJ;
        if (z2) {
            bVar2 = this.cbF.cbw;
            str2 = this.cbF.cbC;
            bVar2.B(0, str2);
            return;
        }
        bVar = this.cbF.cbw;
        str = this.cbF.cbC;
        bVar.iW(str);
    }
}
