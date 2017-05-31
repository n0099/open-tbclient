package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ f djD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(f fVar) {
        this.djD = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putBoolean("is_shut_down_validate", true);
        this.djD.gk(false);
        this.djD.gi(false);
    }
}
