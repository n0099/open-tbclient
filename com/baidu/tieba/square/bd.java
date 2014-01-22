package com.baidu.tieba.square;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class bd implements DialogInterface.OnClickListener {
    final /* synthetic */ bc a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bd(bc bcVar) {
        this.a = bcVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
