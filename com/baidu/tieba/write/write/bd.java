package com.baidu.tieba.write.write;

import android.content.DialogInterface;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class bd implements DialogInterface.OnDismissListener {
    final /* synthetic */ WriteActivity fUM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(WriteActivity writeActivity) {
        this.fUM = writeActivity;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public void onDismiss(DialogInterface dialogInterface) {
        boolean z;
        z = this.fUM.fUt;
        if (z) {
            com.baidu.adp.lib.util.k.b(this.fUM.getPageContext().getPageActivity(), this.fUM.getCurrentFocus());
            this.fUM.fUu = System.currentTimeMillis();
        }
    }
}
