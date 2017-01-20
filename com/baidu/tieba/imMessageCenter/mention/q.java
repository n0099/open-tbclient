package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements View.OnClickListener {
    final /* synthetic */ l djK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(l lVar) {
        this.djK = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ad adVar;
        ad adVar2;
        adVar = this.djK.djC;
        TiebaStatic.eventStat(adVar.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
        adVar2 = this.djK.djC;
        com.baidu.tbadk.core.util.bf.ai(adVar2.getPageContext().getPageActivity());
    }
}
