package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ f duO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(f fVar) {
        this.duO = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.sharedPref.b.um().putBoolean("is_shut_down_validate", true);
        this.duO.gI(false);
        this.duO.gG(false);
    }
}
