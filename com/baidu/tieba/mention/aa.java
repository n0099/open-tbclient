package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class aa implements View.OnClickListener {
    final /* synthetic */ w bGo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(w wVar) {
        this.bGo = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ViewEventCenter AM;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9486, this.bGo.getData(), null, null);
        bVar.setView(this.bGo.getRootView());
        i = this.bGo.position;
        bVar.dV(i);
        AM = this.bGo.AM();
        AM.dispatchMvcEvent(bVar);
    }
}
