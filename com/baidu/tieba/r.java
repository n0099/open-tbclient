package com.baidu.tieba;

import android.view.View;
import com.baidu.tieba.o;
/* loaded from: classes.dex */
class r implements View.OnClickListener {
    final /* synthetic */ o aFW;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(o oVar) {
        this.aFW = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        o.a aVar;
        aVar = this.aFW.aFR;
        aVar.GM();
    }
}
