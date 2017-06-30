package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bl;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ l duq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(l lVar) {
        this.duq = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ad adVar;
        ad adVar2;
        adVar = this.duq.dui;
        TiebaStatic.eventStat(adVar.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
        adVar2 = this.duq.dui;
        bl.aM(adVar2.getPageContext().getPageActivity());
    }
}
