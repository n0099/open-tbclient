package com.baidu.tieba.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cs implements View.OnFocusChangeListener {
    final /* synthetic */ bz bCR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cs(bz bzVar) {
        this.bCR = bzVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        PbActivity pbActivity;
        if (!z) {
            pbActivity = this.bCR.bAW;
            com.baidu.adp.lib.util.l.c(pbActivity.getPageContext().getPageActivity(), view);
        }
    }
}
