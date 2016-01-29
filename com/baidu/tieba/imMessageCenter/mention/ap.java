package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class ap implements View.OnClickListener {
    final /* synthetic */ al cnq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(al alVar) {
        this.cnq = alVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ViewEventCenter oF;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9486, this.cnq.getData(), null, null);
        bVar.setView(this.cnq.getRootView());
        i = this.cnq.position;
        bVar.eQ(i);
        oF = this.cnq.oF();
        oF.dispatchMvcEvent(bVar);
        TiebaStatic.log("c10096");
    }
}
