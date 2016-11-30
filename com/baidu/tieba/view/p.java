package com.baidu.tieba.view;

import android.view.View;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class p implements View.OnClickListener {
    final /* synthetic */ n gfR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.gfR = nVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (com.baidu.adp.lib.util.i.fZ()) {
            this.gfR.JP();
            this.gfR.j(true, com.baidu.adp.lib.util.k.e(this.gfR.Gf.getPageActivity(), r.e.ds500));
            if (this.gfR.gfO != null) {
                this.gfR.gfO.SN();
            }
        }
    }
}
