package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes2.dex */
class b implements View.OnClickListener {
    final /* synthetic */ a dtR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.dtR = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter Fp;
        com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(9483, this.dtR.getData(), null, null);
        Fp = this.dtR.Fp();
        Fp.dispatchMvcEvent(bVar);
    }
}
