package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class ad implements View.OnClickListener {
    final /* synthetic */ aa cbl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(aa aaVar) {
        this.cbl = aaVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter oG;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9484, this.cbl.getData(), null, null);
        oG = this.cbl.oG();
        oG.dispatchMvcEvent(bVar);
    }
}
