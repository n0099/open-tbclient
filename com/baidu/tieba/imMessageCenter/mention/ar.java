package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class ar implements View.OnClickListener {
    final /* synthetic */ an dsQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(an anVar) {
        this.dsQ = anVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ViewEventCenter lF;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9486, this.dsQ.getData(), null, null);
        bVar.setView(this.dsQ.getRootView());
        i = this.dsQ.position;
        bVar.eU(i);
        lF = this.dsQ.lF();
        lF.dispatchMvcEvent(bVar);
        TiebaStatic.log("c10096");
    }
}
