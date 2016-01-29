package com.baidu.tieba.recommendfrs.b;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
import com.baidu.tieba.recommendfrs.data.l;
/* loaded from: classes.dex */
class b implements View.OnClickListener {
    final /* synthetic */ a dGK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.dGK = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        l lVar;
        ViewEventCenter oF;
        l lVar2;
        ViewEventCenter oF2;
        lVar = this.dGK.dGI;
        if (lVar != null) {
            oF = this.dGK.oF();
            if (oF != null) {
                lVar2 = this.dGK.dGI;
                com.baidu.tbadk.mvc.c.b bVar = new com.baidu.tbadk.mvc.c.b(1, lVar2, null, null);
                oF2 = this.dGK.oF();
                oF2.dispatchMvcEvent(bVar);
            }
        }
    }
}
