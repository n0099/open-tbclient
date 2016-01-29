package com.baidu.tieba.recommendfrs.b;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.recommendfrs.data.l;
/* loaded from: classes.dex */
class h implements View.OnClickListener {
    final /* synthetic */ g dGV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.dGV = gVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        l lVar;
        ViewEventCenter oF;
        l lVar2;
        ViewEventCenter oF2;
        lVar = this.dGV.dGI;
        if (lVar != null) {
            oF = this.dGV.oF();
            if (oF != null) {
                lVar2 = this.dGV.dGI;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(1, lVar2, null, null);
                oF2 = this.dGV.oF();
                oF2.dispatchMvcEvent(bVar);
            }
        }
    }
}
