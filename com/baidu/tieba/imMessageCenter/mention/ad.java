package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements View.OnClickListener {
    final /* synthetic */ o dcz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(o oVar) {
        this.dcz = oVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.sharedPref.b.tW().putBoolean("is_shut_down_validate", true);
        this.dcz.gs(false);
        this.dcz.gq(false);
    }
}
