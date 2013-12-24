package com.baidu.tieba.square;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class bc implements DialogInterface.OnClickListener {
    final /* synthetic */ bb a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bc(bb bbVar) {
        this.a = bbVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
