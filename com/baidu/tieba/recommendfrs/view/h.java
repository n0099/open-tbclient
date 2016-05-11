package com.baidu.tieba.recommendfrs.view;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.recommendfrs.data.p;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    final /* synthetic */ g ecw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.ecw = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        p pVar;
        ViewEventCenter kL;
        p pVar2;
        ViewEventCenter kL2;
        pVar = this.ecw.ecm;
        if (pVar != null) {
            kL = this.ecw.kL();
            if (kL != null) {
                pVar2 = this.ecw.ecm;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(1, pVar2, null, null);
                kL2 = this.ecw.kL();
                kL2.dispatchMvcEvent(bVar);
            }
        }
    }
}
