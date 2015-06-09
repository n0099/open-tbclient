package com.baidu.tieba.imMessageCenter.im.chat.notify;

import android.view.View;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class k implements View.OnClickListener {
    final /* synthetic */ d bsx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(d dVar) {
        this.bsx = dVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        com.baidu.tbadk.core.sharedPref.b.sl().putBoolean("is_shut_down_validate", true);
        this.bsx.dn(false);
        this.bsx.dl(false);
    }
}
