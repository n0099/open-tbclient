package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class aq implements View.OnClickListener {
    final /* synthetic */ am cxS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(am amVar) {
        this.cxS = amVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ViewEventCenter oy;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9486, this.cxS.getData(), null, null);
        bVar.setView(this.cxS.getRootView());
        i = this.cxS.position;
        bVar.eW(i);
        oy = this.cxS.oy();
        oy.dispatchMvcEvent(bVar);
        TiebaStatic.log("c10096");
    }
}
