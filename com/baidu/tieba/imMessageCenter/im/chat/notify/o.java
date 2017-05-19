package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes2.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ f dei;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(f fVar) {
        this.dei = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.sharedPref.b.tX().putBoolean("is_shut_down_validate", true);
        this.dei.fX(false);
        this.dei.fV(false);
    }
}
