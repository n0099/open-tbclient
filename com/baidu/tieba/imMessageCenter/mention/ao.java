package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class ao implements View.OnClickListener {
    final /* synthetic */ ak ceM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ao(ak akVar) {
        this.ceM = akVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        ViewEventCenter oM;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9486, this.ceM.getData(), null, null);
        bVar.setView(this.ceM.getRootView());
        i = this.ceM.position;
        bVar.eC(i);
        oM = this.ceM.oM();
        oM.dispatchMvcEvent(bVar);
        TiebaStatic.log("c10096");
    }
}
