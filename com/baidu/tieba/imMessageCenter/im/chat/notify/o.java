package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class o implements View.OnClickListener {
    final /* synthetic */ f dpg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(f fVar) {
        this.dpg = fVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.sharedPref.b.uh().putBoolean("is_shut_down_validate", true);
        this.dpg.go(false);
        this.dpg.gm(false);
    }
}
