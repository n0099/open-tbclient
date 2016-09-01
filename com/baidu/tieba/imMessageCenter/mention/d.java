package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ b dse;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.dse = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter lF;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9484, this.dse.getData(), null, null);
        lF = this.dse.lF();
        lF.dispatchMvcEvent(bVar);
    }
}
