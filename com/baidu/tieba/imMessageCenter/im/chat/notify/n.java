package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ e cdL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(e eVar) {
        this.cdL = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.sharedPref.b.tJ().putBoolean("is_shut_down_validate", true);
        this.cdL.dT(false);
        this.cdL.dR(false);
    }
}
