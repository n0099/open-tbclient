package com.baidu.tieba.pluginCenter.a;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ a coD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.coD = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter oH;
        ViewEventCenter oH2;
        oH = this.coD.oH();
        if (oH != null) {
            oH2 = this.coD.oH();
            oH2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, this.coD.getData(), null, null));
        }
    }
}
