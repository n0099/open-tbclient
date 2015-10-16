package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class co implements View.OnFocusChangeListener {
    final /* synthetic */ cc clJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public co(cc ccVar) {
        this.clJ = ccVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        PbActivity pbActivity;
        if (!z) {
            pbActivity = this.clJ.ciU;
            com.baidu.adp.lib.util.k.c(pbActivity.getPageContext().getPageActivity(), view);
        }
    }
}
