package com.baidu.tieba.mainentrance;

import android.content.DialogInterface;
/* loaded from: classes.dex */
final class p implements DialogInterface.OnClickListener {
    final /* synthetic */ n a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(n nVar) {
        this.a = nVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
