package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class an implements View.OnClickListener {
    final /* synthetic */ ak ceM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(ak akVar) {
        this.ceM = akVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter oM;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9484, this.ceM.getData(), null, null);
        oM = this.ceM.oM();
        oM.dispatchMvcEvent(bVar);
    }
}
