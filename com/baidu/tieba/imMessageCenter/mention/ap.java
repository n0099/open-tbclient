package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class ap implements View.OnClickListener {
    final /* synthetic */ al dno;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(al alVar) {
        this.dno = alVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ViewEventCenter FU;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9486, this.dno.getData(), null, null);
        bVar.setView(this.dno.getRootView());
        i = this.dno.position;
        bVar.eW(i);
        FU = this.dno.FU();
        FU.dispatchMvcEvent(bVar);
        TiebaStatic.log("c10096");
    }
}
