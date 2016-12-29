package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class aq implements View.OnClickListener {
    final /* synthetic */ ap dcT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aq(ap apVar) {
        this.dcT = apVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter lI;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9483, this.dcT.getData(), null, null);
        lI = this.dcT.lI();
        lI.dispatchMvcEvent(bVar);
    }
}
