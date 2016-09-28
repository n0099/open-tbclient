package com.baidu.tieba.pluginCenter.a;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ a eZR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.eZR = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter lF;
        ViewEventCenter lF2;
        lF = this.eZR.lF();
        if (lF != null) {
            lF2 = this.eZR.lF();
            lF2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, this.eZR.getData(), null, null));
        }
    }
}
