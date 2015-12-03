package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ e bZK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(e eVar) {
        this.bZK = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.sharedPref.b.tZ().putBoolean("is_shut_down_validate", true);
        this.bZK.dT(false);
        this.bZK.dR(false);
    }
}
