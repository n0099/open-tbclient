package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ b cmG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.cmG = bVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter oF;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9483, this.cmG.getData(), null, null);
        oF = this.cmG.oF();
        oF.dispatchMvcEvent(bVar);
    }
}
