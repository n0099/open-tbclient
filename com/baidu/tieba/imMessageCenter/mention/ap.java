package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class ap implements View.OnClickListener {
    final /* synthetic */ al ciQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ap(al alVar) {
        this.ciQ = alVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ViewEventCenter ok;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9486, this.ciQ.getData(), null, null);
        bVar.setView(this.ciQ.getRootView());
        i = this.ciQ.position;
        bVar.ew(i);
        ok = this.ciQ.ok();
        ok.dispatchMvcEvent(bVar);
        TiebaStatic.log("c10096");
    }
}
