package com.baidu.tieba.view;

import android.view.View;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class p implements View.OnClickListener {
    final /* synthetic */ n fMj;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.fMj = nVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (com.baidu.adp.lib.util.i.gY()) {
            this.fMj.KD();
            this.fMj.h(true, com.baidu.adp.lib.util.k.g(this.fMj.aaY.getPageActivity(), w.f.ds500));
            if (this.fMj.fMh != null) {
                this.fMj.fMh.Ol();
            }
        }
    }
}
