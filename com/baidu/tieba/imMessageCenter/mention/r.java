package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ k ceq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(k kVar) {
        this.ceq = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.sharedPref.b.tZ().putBoolean("is_shut_down_validate", true);
        this.ceq.dT(false);
        this.ceq.dR(false);
    }
}
