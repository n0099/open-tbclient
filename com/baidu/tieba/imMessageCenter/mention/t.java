package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ k dzt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(k kVar) {
        this.dzt = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.sharedPref.b.um().putBoolean("is_shut_down_validate", true);
        this.dzt.gI(false);
        this.dzt.gG(false);
    }
}
