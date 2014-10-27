package com.baidu.tieba.im.updategroup;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class j implements DialogInterface.OnClickListener {
    final /* synthetic */ g biD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar) {
        this.biD = gVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        DialogInterface.OnClickListener onClickListener;
        DialogInterface.OnClickListener onClickListener2;
        onClickListener = this.biD.aUv;
        if (onClickListener != null) {
            onClickListener2 = this.biD.aUv;
            onClickListener2.onClick(dialogInterface, i);
        }
    }
}
