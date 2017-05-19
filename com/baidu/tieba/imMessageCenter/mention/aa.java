package com.baidu.tieba.imMessageCenter.mention;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ l dgY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(l lVar) {
        this.dgY = lVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.sharedPref.b.tX().putBoolean("is_shut_down_validate", true);
        this.dgY.fX(false);
        this.dgY.fV(false);
    }
}
