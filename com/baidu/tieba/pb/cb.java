package com.baidu.tieba.pb;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class cb implements DialogInterface.OnClickListener {
    final /* synthetic */ bz a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public cb(bz bzVar) {
        this.a = bzVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
