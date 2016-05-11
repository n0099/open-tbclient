package com.baidu.tieba.write.write;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bi implements DialogInterface.OnDismissListener {
    final /* synthetic */ WriteActivity feb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bi(WriteActivity writeActivity) {
        this.feb = writeActivity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        boolean z;
        z = this.feb.fdU;
        if (z) {
            com.baidu.adp.lib.util.k.a(this.feb.getPageContext().getPageActivity(), this.feb.getCurrentFocus());
            this.feb.fdV = System.currentTimeMillis();
        }
    }
}
