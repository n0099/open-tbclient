package com.baidu.tieba.view;

import android.view.View;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
class p implements View.OnClickListener {
    final /* synthetic */ n fWr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.fWr = nVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (com.baidu.adp.lib.util.i.fZ()) {
            this.fWr.La();
            this.fWr.i(true, com.baidu.adp.lib.util.k.e(this.fWr.Gd.getPageActivity(), t.e.ds500));
            if (this.fWr.fWo != null) {
                this.fWr.fWo.Rt();
            }
        }
    }
}
