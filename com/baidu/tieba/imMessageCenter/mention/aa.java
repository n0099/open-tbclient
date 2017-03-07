package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ l dme;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(l lVar) {
        this.dme = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.sharedPref.b.uo().putBoolean("is_shut_down_validate", true);
        this.dme.gm(false);
        this.dme.gk(false);
    }
}
