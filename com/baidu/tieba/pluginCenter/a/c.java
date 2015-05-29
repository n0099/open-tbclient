package com.baidu.tieba.pluginCenter.a;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ a bXJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.bXJ = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter AL;
        ViewEventCenter AL2;
        AL = this.bXJ.AL();
        if (AL != null) {
            AL2 = this.bXJ.AL();
            AL2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, this.bXJ.getData(), null, null));
        }
    }
}
