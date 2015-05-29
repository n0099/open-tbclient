package com.baidu.tieba.mention;

import android.view.View;
/* loaded from: classes.dex */
class p implements View.OnClickListener {
    final /* synthetic */ n bGe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.bGe = nVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        View currentFocus = this.bGe.getActivity().getCurrentFocus();
        if (currentFocus != null) {
            com.baidu.adp.lib.util.n.c(this.bGe.getActivity(), currentFocus);
        }
        this.bGe.getActivity().finish();
    }
}
