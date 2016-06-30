package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ b ddC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.ddC = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter kO;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9483, this.ddC.getData(), null, null);
        kO = this.ddC.kO();
        kO.dispatchMvcEvent(bVar);
    }
}
