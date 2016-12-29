package com.baidu.tieba.view;

import android.view.View;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class p implements View.OnClickListener {
    final /* synthetic */ n fuJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.fuJ = nVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (com.baidu.adp.lib.util.i.fZ()) {
            this.fuJ.Jk();
            this.fuJ.g(true, com.baidu.adp.lib.util.k.e(this.fuJ.Gf.getPageActivity(), r.e.ds500));
            if (this.fuJ.fuG != null) {
                this.fuJ.fuG.Tj();
            }
        }
    }
}
