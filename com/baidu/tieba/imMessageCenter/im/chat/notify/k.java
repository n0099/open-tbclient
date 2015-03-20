package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ d bpB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(d dVar) {
        this.bpB = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.sharedPref.b.rB().putBoolean("is_shut_down_validate", true);
        this.bpB.de(false);
        this.bpB.dc(false);
    }
}
