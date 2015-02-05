package com.baidu.tieba.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cr implements View.OnFocusChangeListener {
    final /* synthetic */ bz bEB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cr(bz bzVar) {
        this.bEB = bzVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        PbActivity pbActivity;
        if (!z) {
            pbActivity = this.bEB.bCF;
            com.baidu.adp.lib.util.l.c(pbActivity.getPageContext().getPageActivity(), view);
        }
    }
}
