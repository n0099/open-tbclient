package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class an implements View.OnClickListener {
    final /* synthetic */ al dno;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(al alVar) {
        this.dno = alVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter FU;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9485, this.dno.getData(), null, null);
        FU = this.dno.FU();
        FU.dispatchMvcEvent(bVar);
        TiebaStatic.log("c10095");
    }
}
