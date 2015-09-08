package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ e bGV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(e eVar) {
        this.bGV = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.sharedPref.b.tx().putBoolean("is_shut_down_validate", true);
        this.bGV.dw(false);
        this.bGV.du(false);
    }
}
