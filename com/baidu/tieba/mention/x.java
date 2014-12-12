package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class x implements View.OnClickListener {
    final /* synthetic */ t bsn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(t tVar) {
        this.bsn = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ViewEventCenter wx;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9486, this.bsn.getData(), null, null);
        bVar.setView(this.bsn.getRootView());
        i = this.bsn.position;
        bVar.dC(i);
        wx = this.bsn.wx();
        wx.dispatchMvcEvent(bVar);
    }
}
