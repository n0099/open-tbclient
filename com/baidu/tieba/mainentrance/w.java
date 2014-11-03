package com.baidu.tieba.mainentrance;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class w implements DialogInterface.OnClickListener {
    final /* synthetic */ t bnd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public w(t tVar) {
        this.bnd = tVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
