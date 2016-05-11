package com.baidu.tieba.recommendfrs.view;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.recommendfrs.data.p;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ a eco;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.eco = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        p pVar;
        ViewEventCenter kL;
        p pVar2;
        ViewEventCenter kL2;
        pVar = this.eco.ecm;
        if (pVar != null) {
            kL = this.eco.kL();
            if (kL != null) {
                pVar2 = this.eco.ecm;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(1, pVar2, null, null);
                kL2 = this.eco.kL();
                kL2.dispatchMvcEvent(bVar);
            }
        }
    }
}
