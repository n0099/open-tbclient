package com.baidu.tieba.pb;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class by implements DialogInterface.OnClickListener {
    final /* synthetic */ bw a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(bw bwVar) {
        this.a = bwVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
