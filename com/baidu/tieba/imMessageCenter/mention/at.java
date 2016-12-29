package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class at implements View.OnClickListener {
    final /* synthetic */ ap dcT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public at(ap apVar) {
        this.dcT = apVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ViewEventCenter lI;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9486, this.dcT.getData(), null, null);
        bVar.setView(this.dcT.getRootView());
        i = this.dcT.position;
        bVar.eX(i);
        lI = this.dcT.lI();
        lI.dispatchMvcEvent(bVar);
        TiebaStatic.log("c10096");
    }
}
