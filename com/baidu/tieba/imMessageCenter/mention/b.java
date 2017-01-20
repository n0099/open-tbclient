package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ a djm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.djm = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter lA;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9483, this.djm.getData(), null, null);
        lA = this.djm.lA();
        lA.dispatchMvcEvent(bVar);
    }
}
