package com.baidu.tieba.pb.pb.main;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class dg implements View.OnFocusChangeListener {
    final /* synthetic */ ct cmY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dg(ct ctVar) {
        this.cmY = ctVar;
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View view, boolean z) {
        PbActivity pbActivity;
        if (!z) {
            pbActivity = this.cmY.cjZ;
            com.baidu.adp.lib.util.k.c(pbActivity.getPageContext().getPageActivity(), view);
        }
    }
}
