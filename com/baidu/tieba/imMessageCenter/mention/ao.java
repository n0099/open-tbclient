package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class ao implements View.OnClickListener {
    final /* synthetic */ an dhk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(an anVar) {
        this.dhk = anVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter kK;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9483, this.dhk.getData(), null, null);
        kK = this.dhk.kK();
        kK.dispatchMvcEvent(bVar);
    }
}
