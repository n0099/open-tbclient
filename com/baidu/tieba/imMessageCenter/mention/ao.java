package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class ao implements View.OnClickListener {
    final /* synthetic */ an dzS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(an anVar) {
        this.dzS = anVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter lI;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9483, this.dzS.getData(), null, null);
        lI = this.dzS.lI();
        lI.dispatchMvcEvent(bVar);
    }
}
