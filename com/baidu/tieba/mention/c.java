package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ b bCU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.bCU = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter zZ;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9483, this.bCU.getData(), null, null);
        zZ = this.bCU.zZ();
        zZ.dispatchMvcEvent(bVar);
    }
}
