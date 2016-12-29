package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ o dcz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(o oVar) {
        this.dcz = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ag agVar;
        ag agVar2;
        agVar = this.dcz.dcq;
        TiebaStatic.eventStat(agVar.getPageContext().getPageActivity(), "notlogin_10", "click", 1, new Object[0]);
        agVar2 = this.dcz.dcq;
        com.baidu.tbadk.core.util.bh.ag(agVar2.getPageContext().getPageActivity());
    }
}
