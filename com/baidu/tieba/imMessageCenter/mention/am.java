package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class am implements View.OnClickListener {
    final /* synthetic */ ak ceM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ak akVar) {
        this.ceM = akVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter oM;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9485, this.ceM.getData(), null, null);
        oM = this.ceM.oM();
        oM.dispatchMvcEvent(bVar);
        TiebaStatic.log("c10095");
    }
}
