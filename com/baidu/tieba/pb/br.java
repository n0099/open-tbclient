package com.baidu.tieba.pb;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class br implements DialogInterface.OnClickListener {
    final /* synthetic */ bp a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public br(bp bpVar) {
        this.a = bpVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
