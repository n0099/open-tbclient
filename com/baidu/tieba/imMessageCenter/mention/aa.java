package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ l djK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(l lVar) {
        this.djK = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.sharedPref.b.tQ().putBoolean("is_shut_down_validate", true);
        this.djK.gv(false);
        this.djK.gt(false);
    }
}
