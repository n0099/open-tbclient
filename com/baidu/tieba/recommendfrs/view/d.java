package com.baidu.tieba.recommendfrs.view;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.recommendfrs.data.p;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ c dZi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.dZi = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        p pVar;
        ViewEventCenter oy;
        p pVar2;
        ViewEventCenter oy2;
        pVar = this.dZi.dZf;
        if (pVar != null) {
            oy = this.dZi.oy();
            if (oy != null) {
                pVar2 = this.dZi.dZf;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(1, pVar2, null, null);
                oy2 = this.dZi.oy();
                oy2.dispatchMvcEvent(bVar);
            }
        }
    }
}
