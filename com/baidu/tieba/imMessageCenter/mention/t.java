package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class t implements View.OnClickListener {
    final /* synthetic */ k cys;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(k kVar) {
        this.cys = kVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.sharedPref.b.sR().putBoolean("is_shut_down_validate", true);
        this.cys.eY(false);
        this.cys.eW(false);
    }
}
