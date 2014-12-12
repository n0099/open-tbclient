package com.baidu.tieba.mainentrance;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class x implements DialogInterface.OnClickListener {
    final /* synthetic */ u brG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(u uVar) {
        this.brG = uVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
