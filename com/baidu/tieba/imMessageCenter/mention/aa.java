package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ l dkD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(l lVar) {
        this.dkD = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.sharedPref.b.uL().putBoolean("is_shut_down_validate", true);
        this.dkD.gm(false);
        this.dkD.gk(false);
    }
}
