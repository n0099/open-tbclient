package com.baidu.tieba.pluginCenter.a;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ a dUV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.dUV = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter kL;
        ViewEventCenter kL2;
        kL = this.dUV.kL();
        if (kL != null) {
            kL2 = this.dUV.kL();
            kL2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, this.dUV.getData(), null, null));
        }
    }
}
