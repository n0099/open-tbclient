package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class ao implements View.OnClickListener {
    final /* synthetic */ al cnq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(al alVar) {
        this.cnq = alVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter oF;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9484, this.cnq.getData(), null, null);
        oF = this.cnq.oF();
        oF.dispatchMvcEvent(bVar);
    }
}
