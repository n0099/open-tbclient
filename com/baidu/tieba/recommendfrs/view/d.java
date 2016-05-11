package com.baidu.tieba.recommendfrs.view;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.recommendfrs.data.p;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ c ecp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.ecp = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        p pVar;
        ViewEventCenter kL;
        p pVar2;
        ViewEventCenter kL2;
        pVar = this.ecp.ecm;
        if (pVar != null) {
            kL = this.ecp.kL();
            if (kL != null) {
                pVar2 = this.ecp.ecm;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(1, pVar2, null, null);
                kL2 = this.ecp.kL();
                kL2.dispatchMvcEvent(bVar);
            }
        }
    }
}
