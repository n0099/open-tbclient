package com.baidu.tieba.im.updategroup;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class i implements DialogInterface.OnClickListener {
    final /* synthetic */ g biR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar) {
        this.biR = gVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        DialogInterface.OnClickListener onClickListener;
        DialogInterface.OnClickListener onClickListener2;
        onClickListener = this.biR.aUK;
        if (onClickListener != null) {
            onClickListener2 = this.biR.aUK;
            onClickListener2.onClick(dialogInterface, i);
        }
    }
}
