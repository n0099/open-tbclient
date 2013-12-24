package com.baidu.tieba.pb;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class ei implements DialogInterface.OnClickListener {
    final /* synthetic */ ef a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ei(ef efVar) {
        this.a = efVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.dismiss();
    }
}
