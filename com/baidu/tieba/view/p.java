package com.baidu.tieba.view;

import android.view.View;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class p implements View.OnClickListener {
    final /* synthetic */ n fYw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.fYw = nVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (com.baidu.adp.lib.util.i.fZ()) {
            this.fYw.JJ();
            this.fYw.j(true, com.baidu.adp.lib.util.k.e(this.fYw.Gd.getPageActivity(), r.e.ds500));
            if (this.fYw.fYt != null) {
                this.fYw.fYt.RL();
            }
        }
    }
}
