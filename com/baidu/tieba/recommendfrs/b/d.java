package com.baidu.tieba.recommendfrs.b;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.recommendfrs.data.l;
/* loaded from: classes.dex */
class d implements View.OnClickListener {
    final /* synthetic */ c dGO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.dGO = cVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        l lVar;
        ViewEventCenter oF;
        l lVar2;
        ViewEventCenter oF2;
        lVar = this.dGO.dGI;
        if (lVar != null) {
            oF = this.dGO.oF();
            if (oF != null) {
                lVar2 = this.dGO.dGI;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(1, lVar2, null, null);
                oF2 = this.dGO.oF();
                oF2.dispatchMvcEvent(bVar);
            }
        }
    }
}
