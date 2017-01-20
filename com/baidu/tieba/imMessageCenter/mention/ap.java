package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class ap implements View.OnClickListener {
    final /* synthetic */ al dke;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(al alVar) {
        this.dke = alVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ViewEventCenter lA;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9486, this.dke.getData(), null, null);
        bVar.setView(this.dke.getRootView());
        i = this.dke.position;
        bVar.eY(i);
        lA = this.dke.lA();
        lA.dispatchMvcEvent(bVar);
        TiebaStatic.log("c10096");
    }
}
