package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ e cil;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(e eVar) {
        this.cil = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.sharedPref.b.uO().putBoolean("is_shut_down_validate", true);
        this.cil.ea(false);
        this.cil.dY(false);
    }
}
