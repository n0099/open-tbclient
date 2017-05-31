package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes2.dex */
class ao implements View.OnClickListener {
    final /* synthetic */ am dmP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(am amVar) {
        this.dmP = amVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter ES;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9485, this.dmP.getData(), null, null);
        ES = this.dmP.ES();
        ES.dispatchMvcEvent(bVar);
        TiebaStatic.log("c10095");
    }
}
