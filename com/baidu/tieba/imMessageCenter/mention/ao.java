package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class ao implements View.OnClickListener {
    final /* synthetic */ an cyR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(an anVar) {
        this.cyR = anVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter kL;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9483, this.cyR.getData(), null, null);
        kL = this.cyR.kL();
        kL.dispatchMvcEvent(bVar);
    }
}
