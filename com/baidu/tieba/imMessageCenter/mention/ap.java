package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class ap implements View.OnClickListener {
    final /* synthetic */ al dmy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(al alVar) {
        this.dmy = alVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ViewEventCenter Fw;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9486, this.dmy.getData(), null, null);
        bVar.setView(this.dmy.getRootView());
        i = this.dmy.position;
        bVar.eT(i);
        Fw = this.dmy.Fw();
        Fw.dispatchMvcEvent(bVar);
        TiebaStatic.log("c10096");
    }
}
