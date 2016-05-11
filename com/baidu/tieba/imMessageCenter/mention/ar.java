package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class ar implements View.OnClickListener {
    final /* synthetic */ an cyR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ar(an anVar) {
        this.cyR = anVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ViewEventCenter kL;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9486, this.cyR.getData(), null, null);
        bVar.setView(this.cyR.getRootView());
        i = this.cyR.position;
        bVar.eC(i);
        kL = this.cyR.kL();
        kL.dispatchMvcEvent(bVar);
        TiebaStatic.log("c10096");
    }
}
