package com.baidu.tieba.mention;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class ad implements View.OnClickListener {
    final /* synthetic */ z bWf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(z zVar) {
        this.bWf = zVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ViewEventCenter oH;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9486, this.bWf.getData(), null, null);
        bVar.setView(this.bWf.getRootView());
        i = this.bWf.position;
        bVar.eh(i);
        oH = this.bWf.oH();
        oH.dispatchMvcEvent(bVar);
        TiebaStatic.log("c10096");
    }
}
