package com.baidu.tieba.pluginCenter.a;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ a dxx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.dxx = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter oF;
        ViewEventCenter oF2;
        oF = this.dxx.oF();
        if (oF != null) {
            oF2 = this.dxx.oF();
            oF2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, this.dxx.getData(), null, null));
        }
    }
}
