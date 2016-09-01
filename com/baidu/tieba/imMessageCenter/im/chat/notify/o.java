package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ f dnI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(f fVar) {
        this.dnI = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.sharedPref.b.tS().putBoolean("is_shut_down_validate", true);
        this.dnI.gl(false);
        this.dnI.gj(false);
    }
}
