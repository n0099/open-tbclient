package com.baidu.tieba.recommendfrs.view;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.recommendfrs.data.p;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ a dZh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.dZh = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        p pVar;
        ViewEventCenter oy;
        p pVar2;
        ViewEventCenter oy2;
        pVar = this.dZh.dZf;
        if (pVar != null) {
            oy = this.dZh.oy();
            if (oy != null) {
                pVar2 = this.dZh.dZf;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(1, pVar2, null, null);
                oy2 = this.dZh.oy();
                oy2.dispatchMvcEvent(bVar);
            }
        }
    }
}
