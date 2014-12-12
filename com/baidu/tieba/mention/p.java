package com.baidu.tieba.mention;

import android.view.View;
/* loaded from: classes.dex */
class p implements View.OnClickListener {
    final /* synthetic */ n bse;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.bse = nVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View currentFocus = this.bse.getActivity().getCurrentFocus();
        if (currentFocus != null) {
            com.baidu.adp.lib.util.l.c(this.bse.getActivity(), currentFocus);
        }
        this.bse.getActivity().onBackPressed();
    }
}
