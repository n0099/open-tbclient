package com.baidu.tieba.more;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class an implements DialogInterface.OnCancelListener {
    final /* synthetic */ aj a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public an(aj ajVar) {
        this.a = ajVar;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public void onCancel(DialogInterface dialogInterface) {
        com.baidu.tieba.c.k.v();
    }
}
