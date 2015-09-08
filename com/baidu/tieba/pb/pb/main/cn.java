package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class cn implements View.OnFocusChangeListener {
    final /* synthetic */ cb cgg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn(cb cbVar) {
        this.cgg = cbVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        PbActivity pbActivity;
        if (!z) {
            pbActivity = this.cgg.ccs;
            com.baidu.adp.lib.util.k.c(pbActivity.getPageContext().getPageActivity(), view);
        }
    }
}
