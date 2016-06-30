package com.baidu.tieba.pluginCenter.a;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ a eEq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.eEq = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter kO;
        ViewEventCenter kO2;
        kO = this.eEq.kO();
        if (kO != null) {
            kO2 = this.eEq.kO();
            kO2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, this.eEq.getData(), null, null));
        }
    }
}
