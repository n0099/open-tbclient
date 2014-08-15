package com.baidu.tieba.mention;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class am implements DialogInterface.OnClickListener {
    final /* synthetic */ ak a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(ak akVar) {
        this.a = akVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
