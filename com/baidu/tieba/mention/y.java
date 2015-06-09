package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class y implements View.OnClickListener {
    final /* synthetic */ w bGo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(w wVar) {
        this.bGo = wVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter AM;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9485, this.bGo.getData(), null, null);
        AM = this.bGo.AM();
        AM.dispatchMvcEvent(bVar);
    }
}
