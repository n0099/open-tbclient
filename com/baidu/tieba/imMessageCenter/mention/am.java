package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class am implements View.OnClickListener {
    final /* synthetic */ al dmy;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(al alVar) {
        this.dmy = alVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter Fw;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9483, this.dmy.getData(), null, null);
        Fw = this.dmy.Fw();
        Fw.dispatchMvcEvent(bVar);
    }
}
