package com.baidu.tieba.view;

import android.view.View;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
class p implements View.OnClickListener {
    final /* synthetic */ n fDD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.fDD = nVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (com.baidu.adp.lib.util.i.fX()) {
            this.fDD.Jy();
            this.fDD.g(true, com.baidu.adp.lib.util.k.e(this.fDD.Fp.getPageActivity(), r.f.ds500));
            if (this.fDD.fDB != null) {
                this.fDD.fDB.MR();
            }
        }
    }
}
