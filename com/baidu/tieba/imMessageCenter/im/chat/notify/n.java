package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class n implements View.OnClickListener {
    final /* synthetic */ e bKl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(e eVar) {
        this.bKl = eVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.sharedPref.b.tr().putBoolean("is_shut_down_validate", true);
        this.bKl.dw(false);
        this.bKl.du(false);
    }
}
