package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class x implements View.OnClickListener {
    final /* synthetic */ t btJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(t tVar) {
        this.btJ = tVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ViewEventCenter wH;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9486, this.btJ.getData(), null, null);
        bVar.setView(this.btJ.getRootView());
        i = this.btJ.position;
        bVar.dI(i);
        wH = this.btJ.wH();
        wH.dispatchMvcEvent(bVar);
    }
}
