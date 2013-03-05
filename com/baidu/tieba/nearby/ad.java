package com.baidu.tieba.nearby;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class ad implements DialogInterface.OnClickListener {
    final /* synthetic */ ab a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar) {
        this.a = abVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
