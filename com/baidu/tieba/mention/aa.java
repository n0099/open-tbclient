package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class aa implements View.OnClickListener {
    final /* synthetic */ w bGn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(w wVar) {
        this.bGn = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ViewEventCenter AL;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9486, this.bGn.getData(), null, null);
        bVar.setView(this.bGn.getRootView());
        i = this.bGn.position;
        bVar.dV(i);
        AL = this.bGn.AL();
        AL.dispatchMvcEvent(bVar);
    }
}
