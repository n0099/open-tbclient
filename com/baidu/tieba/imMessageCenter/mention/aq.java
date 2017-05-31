package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes2.dex */
class aq implements View.OnClickListener {
    final /* synthetic */ am dmP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(am amVar) {
        this.dmP = amVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ViewEventCenter ES;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9486, this.dmP.getData(), null, null);
        bVar.setView(this.dmP.getRootView());
        i = this.dmP.position;
        bVar.eT(i);
        ES = this.dmP.ES();
        ES.dispatchMvcEvent(bVar);
        TiebaStatic.log("c10096");
    }
}
