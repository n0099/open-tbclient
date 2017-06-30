package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes2.dex */
class an implements View.OnClickListener {
    final /* synthetic */ am duL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(am amVar) {
        this.duL = amVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter Fp;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9483, this.duL.getData(), null, null);
        Fp = this.duL.Fp();
        Fp.dispatchMvcEvent(bVar);
    }
}
