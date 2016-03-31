package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class an implements View.OnClickListener {
    final /* synthetic */ am cxS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(am amVar) {
        this.cxS = amVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter oy;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9483, this.cxS.getData(), null, null);
        oy = this.cxS.oy();
        oy.dispatchMvcEvent(bVar);
    }
}
