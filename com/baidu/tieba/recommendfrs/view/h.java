package com.baidu.tieba.recommendfrs.view;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.recommendfrs.data.p;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    final /* synthetic */ g dZp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.dZp = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        p pVar;
        ViewEventCenter oy;
        p pVar2;
        ViewEventCenter oy2;
        pVar = this.dZp.dZf;
        if (pVar != null) {
            oy = this.dZp.oy();
            if (oy != null) {
                pVar2 = this.dZp.dZf;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(1, pVar2, null, null);
                oy2 = this.dZp.oy();
                oy2.dispatchMvcEvent(bVar);
            }
        }
    }
}
