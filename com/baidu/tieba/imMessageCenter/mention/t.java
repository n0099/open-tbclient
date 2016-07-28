package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ k dgL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(k kVar) {
        this.dgL = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.sharedPref.b.sN().putBoolean("is_shut_down_validate", true);
        this.dgL.fP(false);
        this.dgL.fN(false);
    }
}
