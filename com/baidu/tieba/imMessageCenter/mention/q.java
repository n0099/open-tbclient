package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ l dgY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(l lVar) {
        this.dgY = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ad adVar;
        ad adVar2;
        adVar = this.dgY.dgQ;
        TiebaStatic.eventStat(adVar.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
        adVar2 = this.dgY.dgQ;
        com.baidu.tbadk.core.util.bg.aL(adVar2.getPageContext().getPageActivity());
    }
}
