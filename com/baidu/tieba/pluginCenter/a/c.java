package com.baidu.tieba.pluginCenter.a;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ a ePZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.ePZ = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter kK;
        ViewEventCenter kK2;
        kK = this.ePZ.kK();
        if (kK != null) {
            kK2 = this.ePZ.kK();
            kK2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, this.ePZ.getData(), null, null));
        }
    }
}
