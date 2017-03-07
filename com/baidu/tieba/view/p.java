package com.baidu.tieba.view;

import android.view.View;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
class p implements View.OnClickListener {
    final /* synthetic */ n fIe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.fIe = nVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (com.baidu.adp.lib.util.i.gS()) {
            this.fIe.Kd();
            this.fIe.g(true, com.baidu.adp.lib.util.k.g(this.fIe.aaI.getPageActivity(), w.f.ds500));
            if (this.fIe.fIc != null) {
                this.fIe.fIc.NE();
            }
        }
    }
}
