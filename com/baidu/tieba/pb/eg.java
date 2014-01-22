package com.baidu.tieba.pb;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class eg implements DialogInterface.OnClickListener {
    final /* synthetic */ ed a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public eg(ed edVar) {
        this.a = edVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
