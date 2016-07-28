package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ f dca;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(f fVar) {
        this.dca = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.sharedPref.b.sN().putBoolean("is_shut_down_validate", true);
        this.dca.fP(false);
        this.dca.fN(false);
    }
}
