package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ct implements View.OnFocusChangeListener {
    final /* synthetic */ ch bOG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ct(ch chVar) {
        this.bOG = chVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        PbActivity pbActivity;
        if (!z) {
            pbActivity = this.bOG.bLa;
            com.baidu.adp.lib.util.n.c(pbActivity.getPageContext().getPageActivity(), view);
        }
    }
}
