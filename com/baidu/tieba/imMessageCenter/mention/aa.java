package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ l dmu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(l lVar) {
        this.dmu = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
        this.dmu.gk(false);
        this.dmu.gi(false);
    }
}
