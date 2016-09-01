package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ k dsr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(k kVar) {
        this.dsr = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.sharedPref.b.tS().putBoolean("is_shut_down_validate", true);
        this.dsr.gl(false);
        this.dsr.gj(false);
    }
}
