package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ f djq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(f fVar) {
        this.djq = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.sharedPref.b.uo().putBoolean("is_shut_down_validate", true);
        this.djq.gm(false);
        this.djq.gk(false);
    }
}
