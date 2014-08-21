package com.baidu.tieba.mainentrance;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class t implements DialogInterface.OnClickListener {
    final /* synthetic */ q a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(q qVar) {
        this.a = qVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
