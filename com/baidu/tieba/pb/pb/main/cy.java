package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cy implements View.OnFocusChangeListener {
    final /* synthetic */ ci bMm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cy(ci ciVar) {
        this.bMm = ciVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        PbActivity pbActivity;
        if (!z) {
            pbActivity = this.bMm.bIF;
            com.baidu.adp.lib.util.n.c(pbActivity.getPageContext().getPageActivity(), view);
        }
    }
}
