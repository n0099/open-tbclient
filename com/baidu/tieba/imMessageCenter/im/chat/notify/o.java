package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ f csQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(f fVar) {
        this.csQ = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.sharedPref.b.vk().putBoolean("is_shut_down_validate", true);
        this.csQ.ew(false);
        this.csQ.eu(false);
    }
}
