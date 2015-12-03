package com.baidu.tieba.pluginCenter.a;

import android.view.View;
import com.baidu.tbadk.mvc.core.ViewEventCenter;
/* loaded from: classes.dex */
class c implements View.OnClickListener {
    final /* synthetic */ a ddY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(a aVar) {
        this.ddY = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ViewEventCenter oM;
        ViewEventCenter oM2;
        oM = this.ddY.oM();
        if (oM != null) {
            oM2 = this.ddY.oM();
            oM2.dispatchMvcEvent(new com.baidu.tbadk.mvc.c.b(2, this.ddY.getData(), null, null));
        }
    }
}
