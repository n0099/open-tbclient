package com.baidu.tieba.view;

import android.view.View;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class p implements View.OnClickListener {
    final /* synthetic */ n fJN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.fJN = nVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (com.baidu.adp.lib.util.i.gX()) {
            this.fJN.KD();
            this.fJN.g(true, com.baidu.adp.lib.util.k.g(this.fJN.aaX.getPageActivity(), w.f.ds500));
            if (this.fJN.fJL != null) {
                this.fJN.fJL.Oc();
            }
        }
    }
}
