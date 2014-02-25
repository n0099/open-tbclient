package com.baidu.tieba.im.updategroup;

import android.content.DialogInterface;
/* loaded from: classes.dex */
class j implements DialogInterface.OnClickListener {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(g gVar) {
        this.a = gVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public void onClick(DialogInterface dialogInterface, int i) {
        DialogInterface.OnClickListener onClickListener;
        DialogInterface.OnClickListener onClickListener2;
        onClickListener = this.a.p;
        if (onClickListener != null) {
            onClickListener2 = this.a.p;
            onClickListener2.onClick(dialogInterface, i);
        }
    }
}
